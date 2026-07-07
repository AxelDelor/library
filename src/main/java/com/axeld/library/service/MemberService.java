package com.axeld.library.service;

import com.axeld.library.exception.MemberNotFoundException;
import com.axeld.library.model.Member;
import com.axeld.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(()-> new MemberNotFoundException("Le membre que vous cherchez est introuvable"));
    }

}
