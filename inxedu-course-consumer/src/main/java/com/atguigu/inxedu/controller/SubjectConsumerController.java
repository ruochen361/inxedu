package com.atguigu.inxedu.controller;

import com.atguigu.inxedu.bean.SysSubject;
import com.atguigu.inxedu.beanutil.AjaxResult;
import com.atguigu.inxedu.feignservice.CourseFeignService;
import com.atguigu.inxedu.feignservice.SubjectFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * User: ruochen
 * Date:2018/5/14 0014
 */
@Controller
public class SubjectConsumerController {


    @Autowired
    SubjectFeignService subjectFeignService;

    @Autowired
    CourseFeignService courseFeignService;


    @RequestMapping("/subject/index")
    public String index() {
        return "subject";
    }


    @RequestMapping("/subject/loadData")
    @ResponseBody
    public Object loadData() {

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

        return data;
    }


    @RequestMapping("/subject/toAdd{parentId}")
    public String toAdd(String parentId, Model model) {

        model.addAttribute("parentId", parentId);
        return "addSubject";
    }

    @RequestMapping("/subject/doAdd")
    @ResponseBody
    public Object doAdd(SysSubject sysSubject){
        AjaxResult result = new AjaxResult();

        try {
            Date date = new Date();
            sysSubject.setCreateTime(date);
            subjectFeignService.doAdd(sysSubject);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/subject/updateSort")
    @ResponseBody
    public Object updateSort(SysSubject subject){
        AjaxResult ajaxResult = new AjaxResult();

        try {
            subjectFeignService.updateSort(subject);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return ajaxResult;
    }
}
