package com.userinfo.userinfo.service;

import com.userinfo.userinfo.pojo.UserInfo;

import java.util.List;

/**
 * this is the user info service
 */
public interface UserInfoService {
    boolean add(UserInfo userInfo);
    UserInfo get(int id);
    List<UserInfo> list();
    boolean delete(int id);
    boolean update(int id,String phonenumber);
}
