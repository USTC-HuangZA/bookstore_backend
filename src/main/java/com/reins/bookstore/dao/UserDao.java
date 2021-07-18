package com.reins.bookstore.dao;

import com.reins.bookstore.entity.UserInfo;

import java.util.Optional;

public interface UserDao {

    Optional<UserInfo> getUserByUsername(String username);
}
