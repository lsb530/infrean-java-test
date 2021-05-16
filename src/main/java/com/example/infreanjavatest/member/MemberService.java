package com.example.infreanjavatest.member;

import com.example.infreanjavatest.domain.Member;
import com.example.infreanjavatest.domain.Study;
import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);
}