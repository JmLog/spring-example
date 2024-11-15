package com.example.demo.service.member;

import com.example.demo.service.member.entity.Member;
import com.example.demo.service.member.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

    @Test
    void join() {
        // given
        Member member = new Member(1L, "jm", "VIP");

        // when
        memberService.join(member);
        Optional<Member> findMember = memberService.findMember(1L);
        Member memberData = findMember.get();
        Long memberId = memberData.getId();
        String  memberName = memberData.getName();
        String memberGrade = memberData.getGrade();

        // then
        Assertions.assertThat(memberId).isEqualTo(1L);
        Assertions.assertThat(memberName).isEqualTo("jm");
        Assertions.assertThat(memberGrade).isEqualTo("VIP");
    }
}
