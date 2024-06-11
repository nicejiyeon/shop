package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {

        //Model 객체는 Controller 에서 생성된 데이터를 담아 View 로 전달할 때 사용하는 객체이다.
        //addAttribute("key", "value") 메서드를 이용해 view에 전달할 데이터를 key, value형식으로 전달할 수 있다

        var result = itemRepository.findAll();
        model.addAttribute("items", result); // list.html(뷰)에서 items 사용

        var a = new Item();
        System.out.println(a.toString());

        return "list.html";

        //html에 서버데이터 넣어서 보내주려면
        //1. Model model 추가
        //2. model.addAttribue(key,value)
        //3. html에서 thymeleaf 사용
    }
}
