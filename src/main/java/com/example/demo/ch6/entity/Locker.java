package com.example.demo.ch6.entity;


import com.example.demo.ch2.entity.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "locker")
@Getter
@Setter
@NoArgsConstructor
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCKER_ID")
    int lockerId;
    String lockerName;

    @OneToOne(mappedBy = "locker")
    private Member member;

    public Locker(String lockerName) {
        this.lockerName = lockerName;
    }
}
