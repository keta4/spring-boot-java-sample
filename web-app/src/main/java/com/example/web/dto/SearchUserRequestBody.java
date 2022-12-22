package com.example.web.dto;

import lombok.Data;

/**
 * ユーザー検索(POST /users/search) メッセージボディ
 */
@Data
public class SearchUserRequestBody {

    /**
     * 名前
     */
    private String name;

}
