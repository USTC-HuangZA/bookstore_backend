package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.UserDao;
import com.reins.bookstore.entity.UserInfo;
import com.reins.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName UserServiceImpl
 * @Description the implement of user service
 * @Author thunderBoy
 * @Date 2019/11/7 13:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<UserInfo> getUserInfo(String userName){
        return userDao.getUserByUsername(userName);
    }
}
