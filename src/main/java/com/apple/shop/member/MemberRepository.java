package com.apple.shop.member;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username); //findBy[컬럼명] or findByAll[컬럼명] 으로 작성,
                                                      //결과 type, param은 임의로 작성 가능
                                                      // -> drvien Query
}
