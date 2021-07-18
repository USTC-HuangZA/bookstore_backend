package com.reins.bookstore.controller;

import com.reins.bookstore.entity.UserInfo;
import com.reins.bookstore.security.SecurityUtils;
import com.reins.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @ClassName UserController
 * @Description the controller of user
 * @Author thunderBoy
 * @Date 2019/11/7 13:47
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/checkAuth")
    public UserInfo checkAuth(){
        Optional<UserInfo> userInfoOptional =  userService.getUserInfo(SecurityUtils.getCurrentUsername());
        return userInfoOptional.orElse(null);
    }

}
