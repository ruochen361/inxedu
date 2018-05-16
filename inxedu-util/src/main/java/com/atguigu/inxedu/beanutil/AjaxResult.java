package com.atguigu.inxedu.beanutil;

import com.atguigu.inxedu.bean.EduTeacher;
import com.atguigu.inxedu.bean.EduUser;
import lombok.Data;

import java.util.List;

/**
 * User: ruochen
 * Date:2018/5/13 0013
 */
@Data
public class AjaxResult {

    private boolean success;

    private List<EduUser> userList;

    private String message;

    private List<EduTeacher> teacherList;

}
