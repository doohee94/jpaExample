package com.example.demo.ch6.service;

import com.example.demo.ch2.entity.Member;
import com.example.demo.ch6.entity.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class Ch6Service {
    @PersistenceUnit //알아서 persistence.xml 기능하는걸 만들어주는 역할을 하는 거 같은데..??
            EntityManagerFactory emf;

    public void oneToOneRelation() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //여기서 연관관계 주인은 member...
        //locker을 먼저 db에 넣어주고 -> 이에 맞게.. member.. 저장...
        Locker locker = new Locker("testLocker");
        em.persist(locker);
        Member member1 = new Member("lockerTest");
        member1.setLocker(locker);

        em.persist(member1);

        tx.commit();
        em.close();

    }

// public void manyToManySave() {
//
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        Product productA = new Product();
//        productA.setProductId("productA");
//        productA.setName("상품A");
//        em.persist(productA);
//
//        Member member1 = new Member("상품회원");
//        member1.getProducts().add(productA);
//
//        em.persist(member1);
//
//        tx.commit();
//        em.close();
//
//    }
//
//    public void manyToManyFind() {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        Member member = em.find(Member.class, 5);
//        List<Product> products = member.getProducts();
//
//        for (Product product : products) {
//            System.out.println(product.getName());
//        }
//
//
//        tx.commit();
//        em.close();
//    }

//    public void manyToManyFindInverse() {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//       Product product = em.find(Product.class, "productA");
//       List<Member> members = product.getMembers();
//       for(Member member:members){
//           System.out.println(member.getUsername());
//       }
//
//
//        tx.commit();
//        em.close();
//    }

    public void manyTomanyFindOther() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        MemberProductId memberProductId = new MemberProductId();
        memberProductId.setMember(7);
        memberProductId.setProduct("productB");

        MemberProduct memberProduct = em.find(MemberProduct.class, memberProductId);

        Member member = memberProduct.getMember();
        Product product = memberProduct.getProduct();

        System.out.println(member.getUsername());
        System.out.println(product.getName());



        tx.commit();
        em.close();


    }

    public void manyTomanySaveOther() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member1 = new Member("상품저장_복합키사용");
        em.persist(member1);

        Product productB = new Product();
        productB.setProductId("productB");
        productB.setName("상품B");
        em.persist(productB);

        MemberProduct memberProduct = new MemberProduct();
        memberProduct.setMember(member1);
        memberProduct.setProduct(productB);
        memberProduct.setOrderAmount(2);

        em.persist(memberProduct);

        tx.commit();
        em.close();

    }

    public void orderSave() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member1 = new Member("order회원");
        em.persist(member1);

        Product productC = new Product();
        productC.setProductId("productC");
        productC.setName("상품C");
        em.persist(productC);

        Order order = new Order();
        order.setMember(member1);
        order.setProduct(productC);
        order.setOrderAmount(2);

        em.persist(order);


        tx.commit();
        em.close();

    }

    public void orderFind() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Long id = 14L;
        Order order = em.find(Order.class, id);

        Member member = order.getMember();
        Product product = order.getProduct();

        System.out.println(member.getUsername());
        System.out.println(product.getName());
        System.out.println(order.getOrderAmount());


        tx.commit();
        em.close();
    }
}
