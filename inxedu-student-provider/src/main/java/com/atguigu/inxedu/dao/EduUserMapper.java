package com.atguigu.inxedu.dao;

import com.atguigu.inxedu.bean.EduUser;
import com.atguigu.inxedu.bean.UserSearch;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@org.apache.ibatis.annotations.Mapper
public interface EduUserMapper extends Mapper<EduUser> {

    List<EduUser> queryUserList(Map<String,Object> paramMap);
}
