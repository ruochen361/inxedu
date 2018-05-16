package com.atguigu.inxedu.service.impl;

import com.atguigu.inxedu.bean.EduTeacher;
import com.atguigu.inxedu.bean.EduUser;
import com.atguigu.inxedu.dao.TeacherMapper;
import com.atguigu.inxedu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<EduTeacher> getTeacherList() {
        List<EduTeacher> teacherList = teacherMapper.selectAll();
        return teacherList;
    }

    @Override
    public List<EduTeacher> searchTeacherList(Map<String, Object> paramMap) {

        List<EduTeacher> teacherList = teacherMapper.queryTeacherList(paramMap);

        return teacherList;
    }

    @Override
    public void saveTeacher(EduTeacher eduTeacher) {
        teacherMapper.insertSelective(eduTeacher);
    }

    @Override
    public EduTeacher getTeacher(String id) {

        EduTeacher eduTeacher = teacherMapper.selectByPrimaryKey(Integer.parseInt(id));
        return eduTeacher;
    }


    @Override
    public void updateTeacher(EduTeacher eduTeacher) {

        teacherMapper.updateByPrimaryKeySelective(eduTeacher);
    }
}
