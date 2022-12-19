package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.web.entity.User;
import com.example.web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    public String displayList(Model model) {
<<<<<<< HEAD
<<<<<<< HEAD
        List<User> userlist = userService.searchAll();
=======
        var userlist = userService.searchAll();
>>>>>>> 6db1fbd (remove sout)
=======
        List<User> userlist = userService.searchAll();
>>>>>>> f6ca9b3 (explicit type)
        model.addAttribute("userlist", userlist);
        return "user/list";
    }

    @GetMapping("/user/{id}")
    public String displayDetails(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("userData", user);
        return "/user/details";
    }

}
