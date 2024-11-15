package com.example.demo.service.member.repository;

import com.example.demo.service.member.entity.Member;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Optional<Member> findById(Long memberId);
}

