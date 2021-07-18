package com.reins.bookstore.daoimpl;

import com.reins.bookstore.dao.UserDao;
import com.reins.bookstore.entity.UserInfo;
import com.reins.bookstore.repository.UserAuthRepository;
import com.reins.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @ClassName UserDaoImpl
 * @Description the implement of user dao
 * @Author thunderBoy
 * @Date 2019/11/7 13:19
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    UserRepository userRepository;



    @Override
    public Optional<UserInfo> getUserByUsername(String username) {
        Integer userId = userAuthRepository.findUserIdByUserName(username);
        if(userId !=null){
            return userRepository.findById(userId);
        }
        return Optional.empty();
    }
}
