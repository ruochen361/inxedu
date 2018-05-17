package com.atguigu.inxedu.feignservice;

import com.atguigu.inxedu.bean.EduTeacher;
import com.atguigu.inxedu.bean.Page;
import com.atguigu.inxedu.bean.SysSubject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient("inxedu-teacher")
public interface TeacherFeignService {


    @RequestMapping("/teacher/list")
    public List<EduTeacher> getTeacherList();


    @RequestMapping("/teacher/search")
    public List<EduTeacher> searchTeacherList(@RequestBody Map<String, Object> paramMap);


    @RequestMapping("/teacher/doAdd")
    public void saveTeacher(@RequestBody EduTeacher eduTeacher);

    @RequestMapping("/teacher/getOne/{id}")
    public EduTeacher getTeacher(@PathVariable("id") String id);

    @RequestMapping("/teacher/doUpdate")
    public void updateTeacher(@RequestBody EduTeacher eduTeacher);

    @RequestMapping("/teacher/querylist")
    public Page<EduTeacher> queryPage(@RequestBody Map<String, Object> paramMap);
}
