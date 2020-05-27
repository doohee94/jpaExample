package com.example.demo.ch10.service;

import com.example.demo.ch2.entity.Member;
import static com.example.demo.ch2.entity.QMember.*;
import com.example.demo.ch8.entity.Address;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

@Service
public class Ch10Service {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public void jpqlFindSimple() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String userName = "lockerTest";

        //이름기준
//      TypedQuery<Member> query = em.createQuery("select m from Member as m where m.username = :username", Member.class);
//        query.setParameter("username", userName);
//
        //위치기준 (권장 ㄴㄴ)
        TypedQuery<Member> query = em.createQuery("select m from Member as m where m.username = ?1", Member.class).setParameter(1,userName);
        List<Member> rl = query.getResultList();
        System.out.println(rl);

        tx.commit();
        em.close();
    }

    public void critreiaFindSimple() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);

        Root<Member> m = query.from(Member.class);

        CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"),"lockerTest"));
        List<Member> rl = em.createQuery(cq).getResultList();

        System.out.println(rl);

        tx.commit();
        em.close();


    }

    public void jpqlFindProjection() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String query = "select m.companyAddress from Member m";

        List<Address> arr = em.createQuery(query, Address.class).getResultList();
        System.out.println(arr);

        tx.commit();
        em.close();
    }


    public void join() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String teamName = "팀1";

       // String query = "select m from Member m inner join m.team t where t.name =:teamName"; // inner join
        String query = "select m from Member m LEFT join m.team t where t.name = :teamName";

        List<Member> members = em.createQuery(query, Member.class).setParameter("teamName", teamName).getResultList();

        for(Member m : members){
            System.out.println(m.getUsername()+"//"+m.getTeam().getName());
        }

        tx.commit();
        em.close();
    }

    public void queryDSL() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        QMember m = new QMember("m");
//        Member findMember = queryFactory.select(m).from(m).where(m.username.eq("lockerTest")).fetchOne();

        List<Member> members = queryFactory.select(member).from(member).where(member.username.eq("lockerTest")).fetch();


        System.out.println(members);

        tx.commit();
        em.close();
    }
}
