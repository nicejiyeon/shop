package com.apple.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//전체 프로젝트에서 Exception을 잡고 싶으면 ControllerAdvice 어노테이션 추가
@ControllerAdvice
public class MyExceptionHandler {

    //특정 exception에 대해서 하려면 Exception.class 대신 특정 excepiton 명시 하면 됨
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler() {
        return ResponseEntity.status(400).body("zzz");
    }

}
