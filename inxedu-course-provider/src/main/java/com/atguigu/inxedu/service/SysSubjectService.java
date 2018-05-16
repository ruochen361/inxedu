package com.atguigu.inxedu.service;

import com.atguigu.inxedu.bean.SysSubject;

import java.util.List;

public interface SysSubjectService {
    List<SysSubject> getSubjectList();

    SysSubject getSubject(String parentId);

    void saveSubject(SysSubject sysSubject);

    void updateSort(SysSubject subject);
}
