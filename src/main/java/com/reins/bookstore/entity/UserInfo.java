package com.reins.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName User
 * @Description Entity of User
 * @Author thunderBoy
 * @Date 2019/11/7 12:46
 */
@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class UserInfo {

    @Id
    private int userId;
    private String nickname;
    private String name;
    private String tel;
    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private List<UserRole> userRoleList;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserAuth userAuth;

    public int getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTel() {
        return tel;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public UserAuth getUserAuth() {
        return userAuth;
    }
}
