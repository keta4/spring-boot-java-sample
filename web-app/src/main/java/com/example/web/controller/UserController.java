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
import org.springframework.web.bind.annotation.PutMapping;

import com.example.web.dto.UserRequest;
import com.example.web.dto.UserUpdateRequest;
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
     * GET /users
     *
     * @param model
     * @return ユーザー一覧画面
     */
    @GetMapping("/users")
    public String displayUsers(Model model) {
        List<User> userList = userService.searchAll();
        model.addAttribute("userList", userList);
        return "/users/list";
    }

    /**
     * GET /users/{id}
     *
     * @param id
     * @param model
     * @return ユーザー詳細画面
     */
    @GetMapping("/users/{id}")
    public String displayUserDetails(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("userData", user);
        return "/users/details";
    }

    /**
     * GET /users/add
     *
     * @param model
     * @return ユーザー新規登録画面
     */
    @GetMapping(value = "/users/add")
    public String displayAdd(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "/users/add";
    }

    /**
     * POST /users
     *
     * @param userRequest
     * @param result
     * @param model
     * @return ユーザー一覧画面
     */
    @PostMapping(value = "/users")
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
            return "/users/add";
        }

        // ユーザー新規登録
        userService.create(userRequest);
        return "redirect:/users";

    }

    /**
     * GET /users/{id}/edit
     *
     * @param id
     * @param model
     * @return ユーザー情報編集画面
     */
    @GetMapping(value = "/users/{id}/edit")
    public String displayEdit(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        var userUpdateRequest = new UserUpdateRequest();
        userUpdateRequest.setId(user.getId());
        userUpdateRequest.setName(user.getName());
        userUpdateRequest.setAddress(user.getAddress());
        userUpdateRequest.setPhone(user.getPhone());
        model.addAttribute("userUpdateRequest", userUpdateRequest);
        return "/users/edit";
    }

    /**
     * PUT /users/{id}
     *
     * @param userUpdateRequest
     * @param result
     * @param model
     * @return ユーザー詳細画面
     */
    @PutMapping(value = "users/{id}")
    public String updateUser(
            @Validated @ModelAttribute UserUpdateRequest userUpdateRequest,
            BindingResult result,
            Model model) {

        // 入力チェックエラーの場合
        if (result.hasErrors()) {
            var errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "/users/edit";
        }

        // ユーザー新規登録
        userService.update(userUpdateRequest);
        return String.format("redirect:/users/%d", userUpdateRequest.getId());

    }

    /**
     * ユーザー削除
     *
     * @param id
     * @param model
     * @return ユーザー一覧画面
     */
    @GetMapping(path = "/users/{id}/delete")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.delete(id);
        return "redirect:/users";
    }
}
