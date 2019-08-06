package com.userinfo.userinfo.controller;

import com.userinfo.userinfo.pojo.UserInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import com.userinfo.userinfo.service.UserInfoService;

import javax.annotation.Resource;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @description：
 * @author :Henry
 * @since :2019/7/19
 */
@RestController
public class UserInfoController {
    private static final Log log = LogFactory.getLog(UserInfoController.class.getName());
    @Resource
    private UserInfoService userInfoService;

    /**
     *add a new user(the id will be generated automatically)
     *
     * @return boolean
     * @RequestBody (required=false)UserInfo userInfo
     */
    @RequestMapping(value="/add")
    public Object add(String username,int gender,String phonenumber) {
        UserInfo userInfo = new UserInfo(username,gender,phonenumber);
        boolean flag=this.userInfoService.add(userInfo);
        return true;
    }

    /**
     *find the user with a specific id
     * @param id
     * @return boolean
     */
    @RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") int id) {
        UserInfo userInfo=this.userInfoService.get(id);
        return userInfo;
    }

    /**
     * delete the user with a specific id
     * @param id
     * @return boolean
     */
    @RequestMapping(value="/delete/{id}")
    public Object delete(@PathVariable("id") int id) {
        boolean flag=this.userInfoService.delete(id) ;
        return flag;
    }

    /**
     *list all users
     * @return List<UserInfo>
     */
    @RequestMapping(value="/list")
    public Object list() {
        List<UserInfo> userInfoList=this.userInfoService.list() ;
        return userInfoList;
    }

    /**
     * change infos of the user with a specific id
     * @param id
     * @return boolean
     */
    @RequestMapping(value = "/update/{id}")
    public Object update(String phonenumber, @PathVariable("id") int id){
        boolean flag=this.userInfoService.update(id,phonenumber);
        return true;
    };
}
