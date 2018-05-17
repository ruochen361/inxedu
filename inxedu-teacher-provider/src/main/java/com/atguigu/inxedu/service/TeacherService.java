package com.atguigu.inxedu.service;

import com.atguigu.inxedu.bean.EduTeacher;
import com.atguigu.inxedu.bean.Page;

import java.util.List;
import java.util.Map;

public interface TeacherService {


    List<EduTeacher> getTeacherList();

    List<EduTeacher> searchTeacherList(Map<String, Object> paramMap);

    void saveTeacher(EduTeacher eduTeacher);

    EduTeacher getTeacher(String id);

    void updateTeacher(EduTeacher eduTeacher);

    Page<EduTeacher> queryPage(Map<String, Object> paramMap);
}
