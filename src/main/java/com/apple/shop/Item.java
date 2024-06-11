package com.apple.shop;

import jakarta.persistence.*;

@Entity //JPA라이브러리 이용하여 이 어노테이션으로 테이블 생성
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String title;
    public Integer price;

    public String none = "none";

    // package-private (아무것도 안붙인 상태) : 같은 폴더의 클래스에서만 사용 가능
    // public : 모든 곳에서 사용 가능 !
    // private : 다른 클래스에서 사용 불가 !
    //            -> 직접 변경보다 setter 를 쓰면 안전하기 때문.
    // protected : 같은 폴더의 클래스에서만 사용 가능 (예외 : 상속한 클래스는 맘대로 사용 가능)
    // static : 클래스.변수 직접 사용 가능 (new 클래스 하지 않아도 됨)
}
