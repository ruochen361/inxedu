package com.atguigu.inxedu.service.impl;

import com.atguigu.inxedu.bean.SysSubject;
import com.atguigu.inxedu.dao.SysSubjectMapper;
import com.atguigu.inxedu.service.SysSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@Service
public class SysSubjectServiceImpl implements SysSubjectService {

    @Autowired
    private SysSubjectMapper sysSubjectMapper;

    @Override
    public List<SysSubject> getSubjectList() {

        List<SysSubject> sysSubjectList = sysSubjectMapper.selectAllByOrder();
        return sysSubjectList;
    }

    @Override
    public SysSubject getSubject(String parentId) {
        SysSubject subject = sysSubjectMapper.selectByPrimaryKey(Integer.parseInt(parentId));
        return subject;
    }

    @Override
    public void saveSubject(SysSubject sysSubject) {
        sysSubjectMapper.insertSelective(sysSubject);
    }

    @Override
    public void updateSort(SysSubject subject) {
        sysSubjectMapper.updateByPrimaryKeySelective(subject);
    }
}
