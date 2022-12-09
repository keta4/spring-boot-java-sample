package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/list")
    public String displayList(Model model) {
        model.addAttribute("screenName", "ユーザー情報: 一覧画面");
        return "user/list";
    }

}
