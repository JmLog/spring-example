package com.example.demo.member.service;

import com.example.demo.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
