package com.example.demo.ch2.entity;

import com.example.demo.ch6.entity.Locker;
import com.example.demo.ch6.entity.MemberProduct;
import com.example.demo.ch6.entity.Order;
import com.example.demo.ch6.entity.Product;
import com.example.demo.ch7.entity.BaseEntity;
import com.example.demo.ch8.entity.Address;
import com.example.demo.ch8.entity.Period;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "MEMBER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    @JsonBackReference
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Embedded
    Period workPeriod;
    @Embedded
    Address homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "COMPANY_ZIPCODE"))
    })
    Address companyAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOODS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFood = new HashSet<>();

    public Member(String username, Integer age, RoleType roleType, Date createDate, Date lastModifiedDate, String description) {
        this.username = username;
        this.age = age;
        this.roleType = roleType;
        this.createDate = createDate;
        this.lastModifiedDate = lastModifiedDate;
        this.description = description;
    }

    public Member(String username) {
        this.username = username;
    }

    public void setTeam(Team team) {

        if (this.team != null) {// 기존 team이 null 이 아니면 기존 team에 있던 member에 현재 객체를 삭제
            this.team.getMembers().remove(this);
        }

        this.team = team; //이 객체의 team에 새로운 team을 넣어줌
        team.getMembers().add(this); //객체 양방향 연관관계를 위해.. // 새로운 team에 현제 member객체를 add
    }

    public void setCompanyAddress(Address address) {
        this.companyAddress = address;
    }
}

enum RoleType {
    ADMIN, USER
}