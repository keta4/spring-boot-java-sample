package com.example.web.dto;

import lombok.Data;

/**
 * ユーザー検索(GET /users?name=___) メッセージボディ
 */
@Data
public class SearchUserRequestBody {

    /**
     * 名前
     */
    // @NotEmpty(message = "名前を入力してください")
    // @Size(max = 100, message = "名前は100桁以内で入力してください")
    private String name;

}
