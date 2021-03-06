package com.example.demo.ch6.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocker is a Querydsl query type for Locker
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocker extends EntityPathBase<Locker> {

    private static final long serialVersionUID = -172686164L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocker locker = new QLocker("locker");

    public final NumberPath<Integer> lockerId = createNumber("lockerId", Integer.class);

    public final StringPath lockerName = createString("lockerName");

    public final com.example.demo.ch2.entity.QMember member;

    public QLocker(String variable) {
        this(Locker.class, forVariable(variable), INITS);
    }

    public QLocker(Path<? extends Locker> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocker(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocker(PathMetadata metadata, PathInits inits) {
        this(Locker.class, metadata, inits);
    }

    public QLocker(Class<? extends Locker> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.example.demo.ch2.entity.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

