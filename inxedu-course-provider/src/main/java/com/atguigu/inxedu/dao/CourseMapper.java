package com.atguigu.inxedu.dao;


import com.atguigu.inxedu.bean.EduCourse;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CourseMapper extends Mapper<EduCourse> {
    List<EduCourse> selectCourseList();

    EduCourse selectById(Long courseId);
}
