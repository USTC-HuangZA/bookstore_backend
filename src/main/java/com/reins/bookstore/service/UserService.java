package com.reins.bookstore.service;

import com.reins.bookstore.entity.UserInfo;

import java.util.Optional;


public interface UserService {

    Optional<UserInfo> getUserInfo(String userName);
}
