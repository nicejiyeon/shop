package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

@Controller
public class BasicController {
    @GetMapping("/")
    @ResponseBody //string 그대로 리턴해주세요. 하단은 html파일을 리턴하므로 이 어노테이션은 쓰지 않음
    String hello() {
        return "hello";
    }

    @GetMapping("/about")
    String hello2() {
        //return "<h4>hello2</h4>";
        return "index.html"; //static 경로가 default
    }

    @GetMapping("/date")
    @ResponseBody //string 그대로 리턴해주세요. 하단은 html파일을 리턴하므로 이 어노테이션은 쓰지 않음
    String date() {
        return ZonedDateTime.now().toString();
    }

    //main이 아니어도 url로 호출되는 이유는, controller 어노테이션 덕분 (spring의 기능)
}