package com.example.demo.service.discount;

import com.example.demo.service.member.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FixDiscountPolicyTest {

    FixDiscountPolicy fixDiscountPolicy = new FixDiscountPolicy();

    @Test
    @DisplayName("VIP는 1000원 할인이 적용되어야 한다.")
    void vip_o() {
        Member member = new Member(1L, "memberVIP", "VIP");
        int discount = fixDiscountPolicy.discount(member, 20000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 0")
    void vip_x() {
        Member member = new Member(1L, "memberVIP", "BASIC");
        int discount = fixDiscountPolicy.discount(member, 20000);

        Assertions.assertThat(discount).isZero();
    }
}