package com.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.web.dto.UserRequest;
import com.example.web.entity.User;
import com.example.web.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

    /**
     * ユーザー情報 Service
     */
    @Autowired
    private UserService userService;

    /**
     * ユーザー一覧画面を返す
     *
     * @param model
     * @return ユーザー一覧画面
     */
    @GetMapping("/user/list")
    public String displayUsers(Model model) {
        List<User> userList = userService.searchAll();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    /**
     * ユーザー詳細画面を返す
     *
     * @param id
     * @param model
     * @return ユーザー詳細画面
     */
    @GetMapping("/user/{id}")
    public String displayUserDetails(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("userData", user);
        return "/user/details";
    }

    /**
     * ユーザー新規登録画面を返す
     *
     * @param model
     * @return ユーザー新規登録画面
     */
    @GetMapping(value = "/user/add")
    public String displayAdd(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "/user/add";
    }

    /**
     * ユーザー新規登録
     *
     * @param userRequest
     * @param result
     * @param model
     * @return ユーザー一覧画面
     */
    @PostMapping(value = "/user/create")
    public String createUser(
            @Validated @ModelAttribute UserRequest userRequest,
            BindingResult result,
            Model model) {

        // 入力チェックエラーの場合
        if (result.hasErrors()) {
            var errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "/user/add";
        }

        // ユーザー新規登録
        userService.create(userRequest);
        return "redirect:/user/list";

    }

}
