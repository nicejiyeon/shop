package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    //Repository, Service는 RequiredArgsConstructor 어노테이션이 있어야 아래처럼 작성 가능
    private final ItemRepository itemRepository;

    //new ItemService() 쓰면 비효율이어서,
    //ItemService에는 Service 어노테이션 추가하고 Controller에서 사용하면 됨
    @Autowired
    private final ItemService itemService;

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
        
        //파라미터로 @ModelAttribute Item item으로 받아도 됨
        //그럼 itemRepository.save(item); 하면 끝

        //form으로 전송 : requestParam
        //ajax로 전송 : RequestBody

        itemService.saveItem(title,price);

        return "redirect:/list";
    }

    @PostMapping("/add2")
    String add2(@RequestParam Map formData) {
        System.out.println(formData);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}") //URL Parameter문법
    String getDetail(@PathVariable int id, Model model) { //url에 입력한 값을 PathVariable로 알 수 있음

        try {
            //throw new Exception("에러남");
            Optional<Item> result = itemRepository.findById((long) id);
            if(result.isPresent()) { //값 있으면
                System.out.println(result.get().getTitle());
                model.addAttribute("items", result.get()); // list.html(뷰)에서 items 사용
                return "detail.html";
            }else {
                return "redirect:/list";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "redirect:/list";
            //return ResponseEntity.status(400).body("zzz");
        }
    }

    @GetMapping("/moveEdit/{id}")
    String edit(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()) { //값 있으면
            model.addAttribute("items", result.get()); // edit.html(뷰)에서 items 사용
            return "edit.html";
        }else {
            return "redirect:/list";
        }
    }

    @PostMapping("/edit")
    String edit(@RequestParam long id, @RequestParam String title, @RequestParam int price) {
        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:/list";

    }

    @GetMapping("/encode")
    void encode() {
        System.out.println("1->"+new BCryptPasswordEncoder().encode("test"));
        System.out.println("2->"+new BCryptPasswordEncoder().encode("test"));
    }
}
