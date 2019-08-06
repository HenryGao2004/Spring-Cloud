package com.userinfo.userinfo.service.impl;

import org.springframework.stereotype.Service;
import com.userinfo.userinfo.pojo.UserInfo;
import com.userinfo.userinfo.mapper.UserInfoMapper;
import com.userinfo.userinfo.service.UserInfoService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServerImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * add a new user(the id will be generated automatically)
     * @param userInfo
     * @return boolean
     */
    @Override
    public boolean add(UserInfo userInfo) {
        return userInfoMapper.create(userInfo);
    }

    /**
     * find the user with a specific id
     * @param id
     * @return boolean
     */
    @Override
    public UserInfo get(int id) {
        return userInfoMapper.findById(id);
    }

    /**
     *list all users in the database
     * @return List<UserInfo>
     */
    @Override
    public List<UserInfo> list() {
        return userInfoMapper.findAll();
    }

    /**
     * delete the user with a specific id
     * @param id
     * @return boolean
     */
    @Override
    public boolean delete(int id) {return userInfoMapper.delete(id);}

    /**
     * change infos of the user with a specific id
     * @param id
     * @param phonenumber
     * @return boolean
     */
    @Override
    public boolean update(int id,String phonenumber){
        return userInfoMapper.update(id,phonenumber);
    }
}
