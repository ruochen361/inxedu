package com.atguigu.inxedu.service.impl;

import com.atguigu.inxedu.bean.EduTeacher;
import com.atguigu.inxedu.bean.EduUser;
import com.atguigu.inxedu.bean.Page;
import com.atguigu.inxedu.dao.TeacherMapper;
import com.atguigu.inxedu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<EduTeacher> getTeacherList() {
        List<EduTeacher> teacherList = teacherMapper.selectAll();
        return teacherList;
    }

    @Override
    public List<EduTeacher> searchTeacherList(Map<String, Object> paramMap) {

        List<EduTeacher> teacherList = teacherMapper.queryTeacherList(paramMap);

        return teacherList;
    }

    @Override
    public void saveTeacher(EduTeacher eduTeacher) {
        teacherMapper.insertSelective(eduTeacher);
    }

    @Override
    public EduTeacher getTeacher(String id) {

        EduTeacher eduTeacher = teacherMapper.selectByPrimaryKey(Integer.parseInt(id));
        return eduTeacher;
    }


    @Override
    public void updateTeacher(EduTeacher eduTeacher) {

        teacherMapper.updateByPrimaryKeySelective(eduTeacher);
    }


    @Override
    public Page<EduTeacher> queryPage(Map<String, Object> paramMap) {

        Integer pageno = Integer.parseInt((String) paramMap.get("pageno"));
        Integer pagesize = Integer.parseInt((String) paramMap.get("pagesize"));

        Page<EduTeacher> page = new Page(pageno,pagesize);

        int startindex = page.getStartindex();
        paramMap.put("startindex", startindex);
        List<EduTeacher> datas=teacherMapper.queryList(paramMap);

        Integer totalsize =teacherMapper.count(paramMap);

        page.setDatas(datas);
        page.setTotalsize(totalsize);

        Integer totalno = totalsize%pagesize>0?(totalsize/pagesize+1):(totalsize/pagesize);
        page.setTotalno(totalno);
        return page;
    }
}
