package com.example.demo.ch2.service;

import com.example.demo.ch2.entity.Member;
import com.example.demo.ch2.entity.Team;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class Ch2Service {

    @PersistenceUnit //알아서 persistence.xml 기능하는걸 만들어주는 역할을 하는 거 같은데..??
    EntityManagerFactory emf;

    public void test() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();// 커밋하는 순간 영속성 컨텍스트에 저장된 엔티티를 db에 반영-> flush(?)
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


    }

    private void logic(EntityManager em) {


        Member member = new Member();
        member.setUsername("도희");
        member.setAge(2);
        em.persist(member);// 영속성 컨텍스트에 저장..
        member.setAge(20);//entity 값 변경 -> 영속성 컨텍스트에 존재하고 있기 때문에 값을 바꿔도 바뀌는건가..

        //조회
        Member findMember = em.find(Member.class, 0); //조회-> 조회시에 영속성컨텍스트에 존재하는 1차 캐시에서 먼저 원하는 값을 찾고, 없으면 db가서 찾음!

        System.out.println("findmember : "+findMember.getId() + findMember.getAge() + findMember.getUsername());

        em.detach(findMember);
        findMember.setAge(50);

        System.out.println(">>>"+em.find(Member.class, 0));

        //목록조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();//JPQL 사용 -> flush가 자동 호출됨.. 그래서 insert나 update문이 생기는듯

        System.out.println("members : "+members);

        em.detach(member);

        //em.remove(member); //영속성 컨텍스트에서 member 객체를 삭제


    }

    public void saveTeamAndMember() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team1 = new Team("team1","팀1");
        em.persist(team1);

        Member member1 = new Member("회원1");
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member("회원2");
        member2.setTeam(team1);
        em.persist(member2);
        tx.commit();// 커밋하는 순간 영속성 컨텍스트에 저장된 엔티티를 db에 반영-> flush(?)
        em.close();

    }

    public void find() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String spql = "select m from Member m join m.team t where t.name = :teamName";
        List<Member> resultList = em.createQuery(spql, Member.class).setParameter("teamName","팀1").getResultList();

        for(Member member :resultList){
            System.out.println(">>>"+member.getUsername());
        }

        tx.commit();// 커밋하는 순간 영속성 컨텍스트에 저장된 엔티티를 db에 반영-> flush(?)
        em.close();

    }

    public void update() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team2 = new Team("team2","팀2");
        em.persist(team2);

        Member member = em.find(Member.class, 1);
        member.setTeam(team2);
        tx.commit();// 커밋하는 순간 영속성 컨텍스트에 저장된 엔티티를 db에 반영-> flush(?)
        em.close();

    }

    public void deleteRelation() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member1 = em.find(Member.class, 1);
        member1.setTeam(null);

        tx.commit();// 커밋하는 순간 영속성 컨텍스트에 저장된 엔티티를 db에 반영-> flush(?)
        em.close();

    }

    public void deleteEntity() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member1 = em.find(Member.class, 1);
        Member member2 = em.find(Member.class, 2);

        member1.setTeam(null);
        member2.setTeam(null);

        Team team1 = em.find(Team.class, "team1");
        Team team2 = em.find(Team.class, "team2");

        em.remove(team1);
        em.remove(team2);


        tx.commit();// 커밋하는 순간 영속성 컨텍스트에 저장된 엔티티를 db에 반영-> flush(?)
        em.close();

    }

    public void oneToManyFind() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();

        for(Member member : members){
            System.out.println(member.getUsername());
        }


        tx.commit();// 커밋하는 순간 영속성 컨텍스트에 저장된 엔티티를 db에 반영-> flush(?)
        em.close();
    }

    public void oneToManySave() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        Member member1 = new Member("회원2");
        member1.setTeam(team2);
        em.persist(member1);


        Member member2 = new Member("회원3");
        member1.setTeam(team2);
        em.persist(member2);

        tx.commit();// 커밋하는 순간 영속성 컨텍스트에 저장된 엔티티를 db에 반영-> flush(?)
        em.close();

    }
}
