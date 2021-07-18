package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.UserDao;
import com.reins.bookstore.entity.UserInfo;
import com.reins.bookstore.entity.UserRole;
import com.reins.bookstore.service.BookStoreUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookStoreUserDetailsServiceImp implements BookStoreUserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userOptional = userDao.getUserByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (userOptional.isEmpty()){
            throw new UsernameNotFoundException("username '" + username +"' not found");
        }
        UserInfo userInfo = userOptional.get();
        String passWord = userInfo.getUserAuth().getPassword();
        List<UserRole> roles = userInfo.getUserRoleList();
        for(UserRole role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getUserRole()));
        }

        return new User(username, passWord, authorities);
    }
}
