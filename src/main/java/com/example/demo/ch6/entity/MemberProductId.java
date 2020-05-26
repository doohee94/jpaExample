package com.example.demo.ch6.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class MemberProductId implements Serializable {

    private int member;
    private String product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberProductId that = (MemberProductId) o;
        return member == that.member &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, product);
    }
}
