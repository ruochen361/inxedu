package com.atguigu.inxedu.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.inxedu.bean.EduUser;
import com.atguigu.inxedu.bean.UserSearch;
import com.atguigu.inxedu.beanutil.AjaxResult;
import com.atguigu.inxedu.feignservice.EduUserFeignService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@Controller
public class EduUserConsumerController {


    @Autowired
    private EduUserFeignService eduUserFeignService;


    @RequestMapping("/user/list")
    //@ResponseBody
    public String getUserList(Model model){
        List<EduUser> userList = eduUserFeignService.getUserList();

        String userListJson = JSON.toJSONString(userList);
        model.addAttribute("userList",userList);
        return "student";
    }


    @RequestMapping(value = "/user/search",method = RequestMethod.POST)
    @ResponseBody
    public Object searchUserList(UserSearch userSearch){
        AjaxResult ajaxResult = new AjaxResult();
        Map<String,Object> paramMap = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (userSearch.getSearchKey()!=""){
            paramMap.put("searchKey",userSearch.getSearchKey());
        }
        try {
            if (userSearch.getMinTime()!=""){
                Date minTime = simpleDateFormat.parse(userSearch.getMinTime());
                paramMap.put("minTime",userSearch.getMinTime());
            }
            if (userSearch.getMaxTime()!=""){
                Date maxTime = simpleDateFormat.parse(userSearch.getMaxTime());
                paramMap.put("maxTime",userSearch.getMaxTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paramMap.put("isAvalible",userSearch.getIsAvalible());

        try {
            List<EduUser> eduUserList = eduUserFeignService.searchUserList(paramMap);

            ajaxResult.setUserList(eduUserList);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return  ajaxResult;
    }

    @RequestMapping(value = "/user/updateAvalible",method = RequestMethod.POST)
    @ResponseBody
    public Object updateAvalible(@RequestParam(value = "userId") String userId){
        AjaxResult ajaxResult = new AjaxResult();
        /*System.out.println("userId = " + userId);*/
        try {
            eduUserFeignService.updateAvalible(userId);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return  ajaxResult;
    }

    @RequestMapping(value = "/user/updatePassword",method = RequestMethod.POST)
    @ResponseBody
    public Object updatePassword(@RequestParam("firstPassword") String firstPassword,
                                 @RequestParam("secondPassword") String secondPassword,
                                 @RequestParam("userId") String userId ){
        AjaxResult ajaxResult = new AjaxResult();
        Map<String, String> paramMap = new HashMap();

        try {
            if (firstPassword.equals(secondPassword)){
                paramMap.put("password",DigestUtils.md5Hex(secondPassword));
                paramMap.put("userId",userId);
            }else {
                throw new RuntimeException("密码不一致");
            }

            eduUserFeignService.updatePassWord(paramMap);
            ajaxResult.setSuccess(true);

        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return ajaxResult;
    }
}
