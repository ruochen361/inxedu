package com.atguigu.inxedu.controller;

import com.atguigu.inxedu.bean.EduCourse;
import com.atguigu.inxedu.bean.EduCourseKpoint;
import com.atguigu.inxedu.bean.SysSubject;
import com.atguigu.inxedu.service.CourseService;
import com.atguigu.inxedu.service.SysSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@RestController
public class CourseController {

    @Autowired
    SysSubjectService sysSubjectService;

    @Autowired
    CourseService courseService;

    @RequestMapping("/sysSubject/list")
    public List<SysSubject> getSubjectList(){
        List<SysSubject> sysSubjectList =  sysSubjectService.getSubjectList();
        return sysSubjectList;
    }

    @RequestMapping("/subject/toAdd{parentId}")
    public SysSubject getSubject(@PathVariable("parentId") String parentId){

       SysSubject subject =  sysSubjectService.getSubject(parentId);
       return  subject;
    }

    @RequestMapping("/subject/doAdd")
    public void doAdd(@RequestBody SysSubject sysSubject){
        sysSubjectService.saveSubject(sysSubject);
    }


    @RequestMapping("/course/list")
    public List<EduCourse> getCourseList(){
       List<EduCourse> courseList = courseService.getCourseList();
       return courseList;
    }

    @RequestMapping("subject/updateSort")
    public void updateSort(@RequestBody SysSubject subject){
        sysSubjectService.updateSort(subject);
    }


    @RequestMapping("/course/toUpdate/{courseId}")
    public EduCourse getCourse(@PathVariable("courseId") String courseId){
        EduCourse course = courseService.getCourse(courseId);
        return course;
    }


    @RequestMapping("/course/sectionLoadData/{cid}")
    public List<EduCourseKpoint> getCourseKpoint(@PathVariable("cid") String cid){
        List<EduCourseKpoint> eduCourseKpointList= courseService.getCourseKpointList(cid);
        return eduCourseKpointList;
    }
}
