package com.example.demo.member.repository;

import com.example.demo.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}

