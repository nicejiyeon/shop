package com.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private  final PasswordEncoder passwordEncoder;

    public void join(String username, String password, String displayname) throws Exception {

        var member = new Member();
        member.setUsername(username);
        member.setDisplayname(displayname);
        member.setPassword(passwordEncoder.encode(password));

        memberRepository.save(member);

    }


}
