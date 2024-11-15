package com.example.demo.service.order;

import com.example.demo.service.member.entity.Member;
import com.example.demo.service.order.entity.Order;
import com.example.demo.service.member.repository.MemoryMemberRepository;
import com.example.demo.service.member.MemberService;
import com.example.demo.service.member.MemberServiceImpl;
import com.example.demo.service.discount.FixDiscountPolicy;
import com.example.demo.service.discount.RateDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class OrderServiceImplTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

    @Test
    void createOrder_fix() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "jm", "VIP");
        memberService.join(member);
        OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

        // when
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void createOrder_rate() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "jm", "VIP");
        memberService.join(member);
        OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());

        // when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}