package com.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void join(String username, String password, String displayname) {
        var member = new Member();
        var encoder = new BCryptPasswordEncoder();

        member.setUsername(username);
        member.setDisplayname(displayname);
        member.setPassword(encoder.encode(password));

        memberRepository.save(member);  //TODO : DB에 Insert가 안됨

    }


}
