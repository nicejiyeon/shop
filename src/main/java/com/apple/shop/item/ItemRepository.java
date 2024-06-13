package com.apple.shop.item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> { //Item:테이블, Long:Id Type

    //JPA로 데이터 입출력 하려면
    //1. repository 만들기
    //2. 원하는 클래스에 repository 등록
    //3. repository.입출력문법() 쓰기

}
