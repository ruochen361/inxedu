package com.atguigu.inxedu.service;

import com.atguigu.inxedu.bean.EduCourse;
import com.atguigu.inxedu.bean.EduCourseKpoint;

import java.util.List;

public interface CourseService {
    List<EduCourse> getCourseList();

    EduCourse getCourse(String courseId);

    List<EduCourseKpoint> getCourseKpointList(String cid);
}
