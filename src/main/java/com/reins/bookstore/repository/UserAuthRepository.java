package com.reins.bookstore.repository;

import com.reins.bookstore.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserAuthRepository extends JpaRepository<UserAuth,Integer>{

    @Query(value = "select userId from UserAuth where username = :username")
    Integer findUserIdByUserName(@Param("username") String username);

}
