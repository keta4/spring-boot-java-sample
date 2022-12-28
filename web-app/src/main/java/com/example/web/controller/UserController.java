package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.web.dto.CreateUserRequestBody;
import com.example.web.dto.SearchUserRequestBody;
import com.example.web.dto.UpdateUserRequestBody;
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
     * ユーザー一覧
     *
     * @param model
     * @return ユーザー一覧画面
     */
    @GetMapping("/users")
    public String displayUsers(Model model) {

        List<User> userList = userService.searchAll();
        model.addAttribute("userList", userList);
        model.addAttribute("searchUserRequestBody", new SearchUserRequestBody());
        return "/users/list";

    }

    /**
     * ユーザー詳細
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
     * ユーザー検索
     *
     * @param searchUserRequestBody
     * @param model
     * @return ユーザー一覧画面
     */
    @PostMapping("/users/search")
    public String displaySearchUsers(
            @ModelAttribute SearchUserRequestBody searchUserRequestBody,
            Model model) {

        List<User> userList = userService.findByName(searchUserRequestBody);
        model.addAttribute("userList", userList);
        return "/users/list";

    }

    /**
     * ユーザー新規登録画面
     *
     * @param model
     * @return ユーザー新規登録画面
     */
    @GetMapping("/users/add")
    public String displayAdd(Model model) {

        model.addAttribute("createUserRequestBody", new CreateUserRequestBody());
        return "/users/add";

    }

    /**
     * ユーザー新規登録
     *
     * @param createUserRequestBody
     * @param result
     * @param model
     * @return ユーザー一覧画面
     */
    @PostMapping("/users")
    public String createUser(
            @Validated CreateUserRequestBody createUserRequestBody,
            BindingResult result,
            Model model) {

        // 入力チェックエラーの場合
        if (result.hasErrors()) {
            return "/users/add";
        }

        // ユーザー新規登録
        userService.create(createUserRequestBody);
        return "redirect:/users";

    }

    /**
     * ユーザー編集画面
     *
     * @param id
     * @param model
     * @return ユーザー情報編集画面
     */
    @GetMapping("/users/{id}/edit")
    public String displayEdit(@PathVariable Long id, Model model) {

        User user = userService.findById(id);
        var updateUserRequestBody = new UpdateUserRequestBody();
        updateUserRequestBody.setId(user.getId());
        updateUserRequestBody.setName(user.getName());
        updateUserRequestBody.setAddress(user.getAddress());
        updateUserRequestBody.setPhone(user.getPhone());
        model.addAttribute("updateUserRequestBody", updateUserRequestBody);
        return "/users/edit";

    }

    /**
     * ユーザー編集
     *
     * @param updateUserRequestBody
     * @param result
     * @param model
     * @return ユーザー詳細画面
     */
    @PostMapping("users/{id}")
    public String updateUser(
            @Validated UpdateUserRequestBody updateUserRequestBody,
            BindingResult result,
            Model model) {

        // 入力チェックエラーの場合
        if (result.hasErrors()) {
            return "/users/edit";
        }

        // ユーザー編集
        userService.update(updateUserRequestBody);
        return String.format("redirect:/users/%d", updateUserRequestBody.getId());

    }

    /**
     * ユーザー削除
     *
     * @param id
     * @param model
     * @return ユーザー一覧画面
     */
    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id, Model model) {

        userService.delete(id);
        return "redirect:/users";

    }
}
