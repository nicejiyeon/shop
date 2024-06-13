package com.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    @Autowired
    private  final MemberService memberService;

    @GetMapping("/member")
    String join() {
        return "join.html";
    }

    @PostMapping("/join")
    String join(@RequestParam String username, @RequestParam String password, @RequestParam String displayname) {
        memberService.join(username, password, displayname);
        return "redirect:/list";
    }

    @GetMapping("/memberlist")
    void test() {
        var result = memberRepository.findAll();
        System.out.println("result:"+result);
    }
}
