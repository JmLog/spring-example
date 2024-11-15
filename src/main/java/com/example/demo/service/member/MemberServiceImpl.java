package com.example.demo.service.member;

import com.example.demo.service.member.entity.Member;
import com.example.demo.service.member.repository.MemberRepository;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Optional<Member> findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
