package com.atguigu.inxedu.controller;

import com.atguigu.inxedu.bean.EduTeacher;
import com.atguigu.inxedu.bean.EduUser;
import com.atguigu.inxedu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/teacher/list")
    public List<EduTeacher> getTeacherList(){
        List<EduTeacher> teacherList = teacherService.getTeacherList();
        return teacherList;
    }

    @RequestMapping("/teacher/search")
    public List<EduTeacher> searchTeacherList(@RequestBody Map<String, Object> paramMap){
        List<EduTeacher> teacherList = teacherService.searchTeacherList(paramMap);
        return teacherList;
    }

    @RequestMapping("/teacher/doAdd")
    public void saveTeacher(@RequestBody EduTeacher eduTeacher){
        teacherService.saveTeacher(eduTeacher);
    }

    @RequestMapping("/teacher/getOne/{id}")
    public EduTeacher getTeacher(@PathVariable("id") String id){
        EduTeacher eduTeacher = teacherService.getTeacher(id);
        return eduTeacher;
    }

    @RequestMapping("/teacher/doUpdate")
    public void updateTeacher(@RequestBody EduTeacher eduTeacher){
        teacherService.updateTeacher(eduTeacher);
    }
}
