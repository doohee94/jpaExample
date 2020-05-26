package com.example.demo.ch8.service;

import com.example.demo.ch2.entity.Member;
import com.example.demo.ch2.entity.Team;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Service
public class Ch8Service {

    @PersistenceUnit
    private EntityManagerFactory emf;


    public void proxyTest() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();



        Member member2 = em.getReference(Member.class, 3); // 엔티티를 실제 사용하는 지점까지 조회 ㄴㄴ
        System.out.println(em.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(member2));
//        Member member = em.find(Member.class, 3); //즉시호출
//        System.out.println("즉시호출 : "+member);
        System.out.println(em.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(member2));
        System.out.println("실제 사용 호출"+ member2);
        System.out.println(em.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(member2));

        tx.commit();// 커밋하는 순간 영속성 컨텍스트에 저장된 엔티티를 db에 반영-> flush(?)
        em.close();

    }
}
