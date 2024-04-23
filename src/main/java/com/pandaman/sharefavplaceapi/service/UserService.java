package com.pandaman.sharefavplaceapi.service;

import com.pandaman.sharefavplaceapi.domain.User;

import java.util.List;

public interface UserService {
    /**
     * ユーザー全件取得
     *
     * @return List<User>
     */
    List<User> findAll();
}
