package com.reins.bookstore.repository;

import com.reins.bookstore.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo,Integer> {
}
