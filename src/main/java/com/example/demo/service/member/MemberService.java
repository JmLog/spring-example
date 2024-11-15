package com.example.demo.service.member;

import com.example.demo.service.member.entity.Member;

import java.util.Optional;

public interface MemberService {

    void join(Member member);

    Optional<Member> findMember(Long memberId);
}
