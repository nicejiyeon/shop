package com.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;

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
        try {

            var result = memberRepository.findByUsername(username);
            System.out.println("0000"+result);
            if (result.isPresent()){
                System.out.println("11111");
                throw new Exception("존재하는아이디");
            }
            if (username.length() < 8 || password.length() < 8){
                System.out.println("1111");
                throw new Exception("너무짧음");
            }

            memberService.join(username, password, displayname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/list";
    }

    @GetMapping("/memberlist")
    void test() {
        var result = memberRepository.findAll();
        System.out.println("result:"+result);
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/my-page")
    public String myPage(Authentication auth) {
        //컨트롤러에서 파라미터로 Authentication 받으면 현재 로그인한 사용자 정보 출력 가능
        //Authentication 대신 principal 을 사용할 수 도 있음
        /*System.out.println(auth);
        System.out.println(auth.getName());
        System.out.println(auth.getDetails());*/

        return "mypage.html";
    }
}
