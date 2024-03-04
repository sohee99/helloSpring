package com.example.hellospring.controller;

import com.example.hellospring.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {  // 빈 주입
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }
}
