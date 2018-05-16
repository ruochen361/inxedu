package com.atguigu.inxedu.service;

import com.atguigu.inxedu.bean.EduUser;
import com.atguigu.inxedu.bean.UserSearch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */

public interface EduUserService {

    public void saveUsesr(EduUser eduUser);


    public List<EduUser> getUserList();

    List<EduUser> searchUserList(Map<String, Object> paramMap);

    void updateAvalible(String userId);

    void updatePassword(Map<String, String> paramMap);
}
