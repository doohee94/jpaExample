package com.example.demo.ch6.entity;

import com.example.demo.ch2.entity.Member;
import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(MemberProductId.class)
@Data
public class MemberProduct {

    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Nullable
    private int orderAmount;

}
