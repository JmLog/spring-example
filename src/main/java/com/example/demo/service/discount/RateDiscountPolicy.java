package com.example.demo.service.discount;

import com.example.demo.service.member.entity.Member;

import java.util.Objects;

public class RateDiscountPolicy implements DiscountPolicy{

    private int RateDiscountPolicy = 10;

    @Override
    public int discount(Member member, int price) {
        if (Objects.equals(member.getGrade(), "VIP")) {
            return price * RateDiscountPolicy / 100;
        } else {
            return 0;
        }
    }
}
