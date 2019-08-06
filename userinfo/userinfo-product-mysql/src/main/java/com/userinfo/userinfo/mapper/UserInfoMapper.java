package com.userinfo.userinfo.mapper;

import org.apache.ibatis.annotations.Param;
import com.userinfo.userinfo.pojo.UserInfo;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * the mapper is the one which can operate the database directly
 */
public interface UserInfoMapper {
    /**
     * add a new user(the id will be generated automatically)
     * @param userInfo
     * @return
     */
    boolean create(UserInfo userInfo);

    /**
     * find the user with a specific id
     * @param id
     * @return
     */
    UserInfo findById(int id);

    /**
     * list all users in the database
     * @return
     */
    List<UserInfo> findAll();

    /**
     * delete the user with a specific id
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * change infos of the user with a specific id
     * @param id
     * @param phonenumber
     * @return
     */
    boolean update(@Param("id")int id, @Param("phonenumber")String phonenumber);
}