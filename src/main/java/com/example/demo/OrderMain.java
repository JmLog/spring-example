package com.example.demo;

import com.example.demo.config.AppConfig;
import com.example.demo.service.member.entity.Member;
import com.example.demo.service.order.entity.Order;
import com.example.demo.service.member.MemberService;
import com.example.demo.service.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "jm", "VIP");
        memberService.join(member);
        System.out.println("member = " + member.toString());

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        Order order = orderService.createOrder(member.getId(), "itemA", 20000);

        System.out.println("order = " + order);
    }
}
