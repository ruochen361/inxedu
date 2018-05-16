package com.atguigu.inxedu.feignservice;

import com.atguigu.inxedu.bean.SysSubject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("inxedu-course")
public interface SubjectFeignService {



    @RequestMapping("/subject/toAdd{parentId}")
    public SysSubject getSubject(@PathVariable("parentId") String parentId);

    @RequestMapping("/subject/doAdd")
    public void doAdd(@RequestBody SysSubject sysSubject);

    @RequestMapping("subject/updateSort")
    public void updateSort(@RequestBody SysSubject subject);
}
