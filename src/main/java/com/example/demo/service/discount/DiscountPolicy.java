package com.example.demo.service.discount;

import com.example.demo.service.member.entity.Member;

public interface DiscountPolicy {
    /**
     * 할인 대상 금액
     */
    int discount(Member member, int price);
}
