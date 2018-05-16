package com.atguigu.inxedu.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.inxedu.bean.EduUser;
import com.atguigu.inxedu.bean.UserSearch;
import com.atguigu.inxedu.dao.EduUserMapper;
import com.atguigu.inxedu.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@Service
public class EduUserServiceImpl implements EduUserService {

    @Autowired
    private EduUserMapper eduUserDao;

    @Override
    public void saveUsesr(EduUser eduUser) {
        eduUserDao.insertSelective(eduUser);
    }

    @Override
    public List<EduUser> getUserList() {
        List<EduUser> eduUserList = eduUserDao.selectAll();
        return eduUserList;
    }

    @Override
    public List<EduUser> searchUserList(Map<String, Object> paramMap) {

        List<EduUser> eduUserList = eduUserDao.queryUserList(paramMap);
        return eduUserList;
    }

    @Override
    public void updateAvalible(String userId) {
        EduUser queryEduUser = new EduUser();
        queryEduUser.setUserId(Integer.parseInt(userId));
        EduUser eduUser = eduUserDao.selectOne(queryEduUser);
        Integer isAvalible = eduUser.getIsAvalible();
        if (isAvalible==1){
            queryEduUser.setIsAvalible(0);
            eduUserDao.updateByPrimaryKeySelective(queryEduUser);
        }else if (isAvalible==0){
            queryEduUser.setIsAvalible(1);
            eduUserDao.updateByPrimaryKeySelective(queryEduUser);
        }
    }

    @Override
    public void updatePassword(Map<String, String> paramMap) {
        EduUser eduUser = new EduUser();
        eduUser.setUserId(Integer.parseInt(paramMap.get("userId")));
        eduUser.setPassword(paramMap.get("password"));
        eduUserDao.updateByPrimaryKeySelective(eduUser);

    }
}
