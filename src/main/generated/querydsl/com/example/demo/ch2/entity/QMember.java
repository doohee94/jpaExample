package com.example.demo.ch2.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1888242902L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final com.example.demo.ch8.entity.QAddress companyAddress;

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final StringPath description = createString("description");

    public final SetPath<String, StringPath> favoriteFood = this.<String, StringPath>createSet("favoriteFood", String.class, StringPath.class, PathInits.DIRECT2);

    public final com.example.demo.ch8.entity.QAddress homeAddress;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> lastModifiedDate = createDateTime("lastModifiedDate", java.util.Date.class);

    public final com.example.demo.ch6.entity.QLocker locker;

    public final ListPath<com.example.demo.ch6.entity.MemberProduct, com.example.demo.ch6.entity.QMemberProduct> memberProducts = this.<com.example.demo.ch6.entity.MemberProduct, com.example.demo.ch6.entity.QMemberProduct>createList("memberProducts", com.example.demo.ch6.entity.MemberProduct.class, com.example.demo.ch6.entity.QMemberProduct.class, PathInits.DIRECT2);

    public final ListPath<com.example.demo.ch6.entity.Order, com.example.demo.ch6.entity.QOrder> orders = this.<com.example.demo.ch6.entity.Order, com.example.demo.ch6.entity.QOrder>createList("orders", com.example.demo.ch6.entity.Order.class, com.example.demo.ch6.entity.QOrder.class, PathInits.DIRECT2);

    public final EnumPath<RoleType> roleType = createEnum("roleType", RoleType.class);

    public final QTeam team;

    public final StringPath username = createString("username");

    public final com.example.demo.ch8.entity.QPeriod workPeriod;

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.companyAddress = inits.isInitialized("companyAddress") ? new com.example.demo.ch8.entity.QAddress(forProperty("companyAddress")) : null;
        this.homeAddress = inits.isInitialized("homeAddress") ? new com.example.demo.ch8.entity.QAddress(forProperty("homeAddress")) : null;
        this.locker = inits.isInitialized("locker") ? new com.example.demo.ch6.entity.QLocker(forProperty("locker"), inits.get("locker")) : null;
        this.team = inits.isInitialized("team") ? new QTeam(forProperty("team")) : null;
        this.workPeriod = inits.isInitialized("workPeriod") ? new com.example.demo.ch8.entity.QPeriod(forProperty("workPeriod")) : null;
    }

}

