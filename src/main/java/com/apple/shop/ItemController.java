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

        var result = itemRepository.findAll();
        model.addAttribute("items", result);

        var a = new Item();
        System.out.println(a.toString());

        return "list.html";

        //html에 서버데이터 넣어서 보내주려면
        //1. Model model 추가
        //2. model.addAttribue(key,value)
        //3. html에서 thymeleaf 사용
    }
}
