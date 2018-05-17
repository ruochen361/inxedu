package com.atguigu.inxedu.service.impl;

import com.atguigu.inxedu.bean.EduCourse;
import com.atguigu.inxedu.bean.EduCourseKpoint;
import com.atguigu.inxedu.dao.CourseMapper;
import com.atguigu.inxedu.dao.EduCourseKpointMapper;
import com.atguigu.inxedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    CourseMapper courseMapper;


    @Autowired
    EduCourseKpointMapper eduCourseKpointMapper;

    @Override
    public List<EduCourse> getCourseList() {

      List<EduCourse> courseList =  courseMapper.selectCourseList();
      return courseList;
    }

    @Override
    public EduCourse getCourse(String courseId) {

        EduCourse course = courseMapper.selectById(Long.parseLong(courseId));
        return course;
    }

    @Override
    public List<EduCourseKpoint> getCourseKpointList(String cid) {
        List<EduCourseKpoint> courseKpointList = eduCourseKpointMapper.selectList(cid);
        return courseKpointList;
    }
}
