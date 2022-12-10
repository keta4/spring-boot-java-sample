package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    public String displayList(Model model) {
        var userlist = userService.searchAll();
        System.out.println(userlist);
        model.addAttribute("userlist", userlist);
        return "user/list";
    }

    @GetMapping("/user/{id}")
    public String displayDetails(@PathVariable Long id, Model model) {
        var user = userService.findById(id);
        model.addAttribute("userData", user);
        return "/user/details";
    }

}
