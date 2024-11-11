package com.example.demo.member.service;

import com.example.demo.member.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
