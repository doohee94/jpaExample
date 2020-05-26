package com.example.demo.ch6.entity;

import com.example.demo.ch2.entity.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonBackReference
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    @JsonBackReference
    private Product product;

    @Nullable
    private int orderAmount;


}
