package com.example.demo.ch10.service;

import com.example.demo.ch2.entity.Member;
import com.example.demo.ch8.entity.Address;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class Ch10Service {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public void jpqlFindSimple() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String jpql = "select m from Member as m where m.username = 'lockerTest'";

        List<Member> resultList = em.createQuery(jpql, Member.class).getResultList();

        System.out.println(resultList);

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
}
