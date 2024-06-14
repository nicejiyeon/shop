package com.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        DB에서 username을 가진 유저를 찾아와서
//        return new User(유저아이디, 비번, 권한) 해주세요
        var result = memberRepository.findByUsername(username);
        if(result.isEmpty()) {
            throw new UsernameNotFoundException("ID Not Found");
        }
        var user = result.get();
        List<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority("normal")); //유저의 권한 -> 다른 클래스에서 권한도 같이 출력

        //return new User(user.getUsername(), user.getPassword(), auth);
        CustomUser customUser = new CustomUser(user.getUsername(), user.getPassword(), auth);
        customUser.id = user.getId();
        customUser.displayName = user.getDisplayname();
        return customUser;
    }

    class CustomUser extends User {

        public Long id;
        public String displayName;

        public CustomUser(String username,
                          String password,
                          List<GrantedAuthority> authorities) {
            super(username, password, authorities);
        }
    }

} 