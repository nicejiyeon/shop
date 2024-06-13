package com.apple.shop.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    @GetMapping("/board")
    String list(Model model) {

        var result = boardRepository.findAll();
        model.addAttribute("board", result); //html로 보낼 데이터

        System.out.println(result.get(0).title);
        return "board.html";
    }
}
