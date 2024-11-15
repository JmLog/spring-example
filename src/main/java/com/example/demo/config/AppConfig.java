package com.example.demo.config;

import com.example.demo.service.discount.RateDiscountPolicy;
import com.example.demo.service.member.MemberService;
import com.example.demo.service.member.MemberServiceImpl;
import com.example.demo.service.member.repository.JpaMemberRepository;
import com.example.demo.service.member.repository.MemberRepository;
import com.example.demo.service.discount.DiscountPolicy;
import com.example.demo.service.discount.FixDiscountPolicy;
import com.example.demo.service.order.OrderService;
import com.example.demo.service.order.OrderServiceImpl;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final EntityManager em;

    @Autowired
    public AppConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
            memberRepository(),
            discountPolicy()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
