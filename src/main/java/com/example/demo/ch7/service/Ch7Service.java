package com.example.demo.ch7.service;

import com.example.demo.ch7.entity.Parent;
import com.example.demo.ch7.entity.ParentId;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Service
public class Ch7Service {
    @PersistenceUnit
    EntityManagerFactory emf;

    public void compositeKeySave() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Parent parent = new Parent();
        parent.setId1("myId3");
        parent.setId2("myId4");
        parent.setName("이름이름");

        em.persist(parent);

        ParentId parentId = new ParentId("myId3","myId4");
        Parent parentFind = em.find(Parent.class, parentId);

        System.out.println(parentFind);

        tx.commit();
        em.close();


    }

}
