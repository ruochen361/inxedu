package com.atguigu.inxedu.controller;

import com.atguigu.inxedu.bean.EduCourse;
import com.atguigu.inxedu.bean.EduTeacher;
import com.atguigu.inxedu.bean.SysSubject;
import com.atguigu.inxedu.feignservice.CourseFeignService;
import com.atguigu.inxedu.feignservice.TeacherFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@Controller
public class CourseConsumerController {

    @Autowired
    private CourseFeignService courseFeignService;

    @Autowired
    private TeacherFeignService teacherFeignService;

    @RequestMapping("/course/list")
    public String  getCourseList(Model model){
       List<EduCourse> courseList = courseFeignService.getCourseList();
       model.addAttribute("courseList",courseList);
        List<SysSubject> sysSubjectList = courseFeignService.getSubjectList();
        model.addAttribute("sysSubjectList",sysSubjectList);
       return "course";
    }

    @RequestMapping("/course/toUpdate")
    public String toUpdate(String courseId,Model model){

        List<SysSubject> sysSubjectList = courseFeignService.getSubjectList();
        model.addAttribute("sysSubjectList",sysSubjectList);

        List<EduTeacher> allTeacher = teacherFeignService.getTeacherList();
        model.addAttribute("allTeacher",allTeacher);

        EduCourse course = courseFeignService.getCourse(courseId);
        model.addAttribute("course",course);

        return "update";
    }

}
