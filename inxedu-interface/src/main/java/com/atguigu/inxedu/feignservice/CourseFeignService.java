package com.atguigu.inxedu.feignservice;

import com.atguigu.inxedu.bean.EduCourse;
import com.atguigu.inxedu.bean.SysSubject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("inxedu-course")
public interface CourseFeignService {

    @RequestMapping("/sysSubject/list")
    public List<SysSubject> getSubjectList();

    @RequestMapping("/course/list")
    public List<EduCourse> getCourseList();

    @RequestMapping("/course/toUpdate/{courseId}")
    public EduCourse getCourse(@PathVariable("courseId") String courseId);
}
