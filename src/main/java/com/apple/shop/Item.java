package com.apple.shop;

import jakarta.persistence.*;

@Entity //JPA라이브러리 이용하여 이 어노테이션으로 테이블 생성
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String title;
    public Integer price;
}
