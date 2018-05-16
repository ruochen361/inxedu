package com.atguigu.inxedu.service;

import com.atguigu.inxedu.bean.EduCourse;

import java.util.List;

public interface CourseService {
    List<EduCourse> getCourseList();

    EduCourse getCourse(String courseId);
}
