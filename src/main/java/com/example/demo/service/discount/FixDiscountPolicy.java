package com.example.demo.service.discount;

import com.example.demo.service.member.entity.Member;

import java.util.Objects;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (Objects.equals(member.getGrade(), "VIP")) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
