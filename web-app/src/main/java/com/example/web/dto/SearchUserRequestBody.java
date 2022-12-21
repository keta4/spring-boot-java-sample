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
    private String name;

}
