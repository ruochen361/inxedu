package com.atguigu.inxedu.controller;

import com.atguigu.inxedu.bean.EduUser;
import com.atguigu.inxedu.bean.UserSearch;
import com.atguigu.inxedu.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@RestController
public class EduUserController {

    @Autowired
    private EduUserService eduUserService;



    @RequestMapping("/user/list")
    public List<EduUser>  getUserList(){
        List<EduUser> userList = eduUserService.getUserList();
        return userList;
    }


    @RequestMapping("/user/search")
    public List<EduUser> searchUserList(@RequestBody Map<String, Object> paramMap){
        List<EduUser> eduUserList = eduUserService.searchUserList(paramMap);
        return eduUserList;
    }


    @RequestMapping("user/updateAvalible/{userId}")
    public void updateAvalible(@PathVariable("userId") String userId){
        eduUserService.updateAvalible(userId);

    }

    @RequestMapping("/user/updatePassword")
    public void updatePassWord(@RequestBody Map<String, String> paramMap){
        eduUserService.updatePassword(paramMap);
    }
}
