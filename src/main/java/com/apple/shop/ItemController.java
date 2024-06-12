package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String add(@RequestParam(name="title") String title,
               @RequestParam int price) {

        //form으로 전송 : requestParam
        //ajax로 전송 : RequestBody

        System.out.println(title);
        System.out.println(price);

        var item = new Item();
        //public type 일 때
        //item.title = title;
        //item.price = Integer.parseInt(price);

        //private type 일 때
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:/list";
    }

    @PostMapping("/add2")
    String add2(@RequestParam Map formData) {
        System.out.println(formData);
        return "redirect:/list";
    }

    @GetMapping("/encode")
    void encode() {
        System.out.println("1->"+new BCryptPasswordEncoder().encode("test"));
        System.out.println("2->"+new BCryptPasswordEncoder().encode("test"));
    }
}
