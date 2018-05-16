package com.atguigu.inxedu.dao;

import com.atguigu.inxedu.bean.EduTeacher;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface TeacherMapper extends Mapper<EduTeacher> {

    List<EduTeacher> queryTeacherList(Map<String, Object> paramMap);
}
