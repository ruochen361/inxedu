package com.atguigu.inxedu.dao;

import com.atguigu.inxedu.bean.SysSubject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SysSubjectMapper extends Mapper<SysSubject> {
    List<SysSubject> selectAllByOrder();
}
