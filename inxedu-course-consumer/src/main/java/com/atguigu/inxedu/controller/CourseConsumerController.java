package com.atguigu.inxedu.controller;

import com.atguigu.inxedu.bean.EduCourse;
import com.atguigu.inxedu.bean.EduCourseKpoint;
import com.atguigu.inxedu.bean.EduTeacher;
import com.atguigu.inxedu.bean.SysSubject;
import com.atguigu.inxedu.feignservice.CourseFeignService;
import com.atguigu.inxedu.feignservice.TeacherFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        List<SysSubject> data = new ArrayList<>();
        SysSubject root = null;
        List<SysSubject> subjectList = courseFeignService.getSubjectList();
        Map<Integer, SysSubject> sysSubjectMap = new HashMap<>();
        for (SysSubject sysSubject : subjectList) {
            sysSubject.setName(sysSubject.getSubjectName());
            sysSubjectMap.put(sysSubject.getSubjectId(), sysSubject);
        }
        for (SysSubject subject : subjectList) {
            SysSubject child = subject;
            if (child.getParentId() == 0) {
                root = child;
                root.setOpen(true);
                data.add(root);
            } else {
                SysSubject parent = sysSubjectMap.get(child.getParentId());
                parent.getChildren().add(child);
            }
        }
        model.addAttribute("data",data);

        return "update";
    }

    @RequestMapping("/course/toCourseKpoint")
    public String toCourseKpoint(String courseId,Model model){

        EduCourse course = courseFeignService.getCourse(courseId);
        model.addAttribute("course",course);
        return "courseKpoint";
    }


    @RequestMapping("/course/sectionLoadData/{cid}")
    @ResponseBody
    public Object sectionLoadData(@PathVariable("cid") String cid) {

        List<EduCourseKpoint> data = new ArrayList<>();
        EduCourseKpoint root = null;

        List<EduCourseKpoint> courseKpointList = courseFeignService.getCourseKpoint(cid);
        Map<Integer, EduCourseKpoint> courseKpointMap = new HashMap<>();
        for (EduCourseKpoint courseKpoint : courseKpointList) {
            courseKpointMap.put(Integer.parseInt(courseKpoint.getKpointId()), courseKpoint);
        }
        for (EduCourseKpoint point : courseKpointList) {
            EduCourseKpoint child = point;
            if (child.getParentId() == 0) {
                root = child;
                data.add(root);
            } else {
                EduCourseKpoint parent = courseKpointMap.get(child.getParentId());
                parent.getChildren().add(child);
            }
        }

        return data;
    }

}
