package com.apple.shop.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity //JPA라이브러리 이용하여 이 어노테이션으로 테이블 생성
@Getter
@Setter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    private Integer price;

    // package-private (아무것도 안붙인 상태) : 같은 폴더의 클래스에서만 사용 가능
    // public : 모든 곳에서 사용 가능 !
    // private : 다른 클래스에서 사용 불가 !
    //            -> 직접 변경보다 setter 를 쓰면 안전하기 때문.
    // protected : 같은 폴더의 클래스에서만 사용 가능 (예외 : 상속한 클래스는 맘대로 사용 가능)
    // static : 클래스.변수 직접 사용 가능 (new 클래스 하지 않아도 됨)
}
