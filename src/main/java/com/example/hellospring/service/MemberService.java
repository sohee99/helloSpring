package com.example.hellospring.service;

import com.example.hellospring.controller.Member;
import com.example.hellospring.controller.MemberDTO;
import com.example.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {   // 빈 주입
        this.memberRepository = memberRepository;
    }

    public List<MemberDTO> getAllMembers() {
        List<Member> memberList = memberRepository.findAll();				// 멤버 목록 얻기

        List<MemberDTO> resultList = memberList.stream()   // MemberDTO로 변환하여 return
                .map(member -> new MemberDTO(member.getId(), member.getName())).toList();
        return resultList;
    }
}
