package com.example.demo.ch9.service;

import com.example.demo.ch2.entity.Member;
import com.example.demo.ch7.entity.Parent;
import com.example.demo.ch7.entity.ParentId;
import com.example.demo.ch8.entity.Address;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.HashSet;
import java.util.Set;

@Service
public class Ch9Service {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public void nullInEmbedded() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member  = new Member("testEmeb");
        member.setHomeAddress(null);

        Address arr =  new Address("인천","석정로","21501");


        member.setCompanyAddress(arr);

        em.persist(member);

        tx.commit();
        em.close();

    }

    public void copyObj() throws CloneNotSupportedException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member1 = new Member("copyObj");
        member1.setCompanyAddress(new Address("인","천","광"));
        Address arr = member1.getCompanyAddress();

        Address newArr = (Address) arr.clone();

        Member member2 = new Member("copy22");
        member2.setCompanyAddress(newArr);

        em.persist(member1);
        em.persist(member2);

        tx.commit();
        em.close();
    }


    public void elementCollection() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member("elemColl");
        Set<String> food  =  new HashSet<>();
        food.add("치킨");
        food.add("김치볶음밥");
        food.add("양꼬치");
        food.add("만두");
        food.add("마라탕");
        food.add("마라샹궈");
        food.add("꿔바로우");
        food.add("페레로로쉐");
        food.add("쿠쿠다스");
        food.add("티라미슈");
        food.add("타르트");
        food.add("연어");
        food.add("랍스타");
        food.add("킹크랩");
        food.add("새우");
        food.add("꽃게");

        member.setFavoriteFood(food);
        em.persist(member);

        tx.commit();
        em.close();


    }

    public void deleteElement() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = em.find(Member.class, 29);

        Set<String> food = member.getFavoriteFood();
        food.remove("랍스타");
        food.add("알리오올리오");




        tx.commit();
        em.close();

    }
}
