package com.example.demo.controller;

import com.example.demo.dto.member.JoinRequest;
import com.example.demo.service.member.MemberService;
import com.example.demo.service.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public void join(@RequestBody JoinRequest joinRequest) {
        Member member = new Member(null, joinRequest.getName(), joinRequest.getGrade());
        memberService.join(member);
    }
}
