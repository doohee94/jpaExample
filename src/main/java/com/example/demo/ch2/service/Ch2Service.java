package com.example.demo.ch2.service;

import com.example.demo.ch2.entity.Member;
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
        emf.close();

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

        //목록조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();//JPQL 사용

        System.out.println("members : "+members);

        em.detach(member);
        em.merge(member);
        //em.remove(member); //영속성 컨텍스트에서 member 객체를 삭제


    }

}
