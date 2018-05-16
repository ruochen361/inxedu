package com.atguigu.inxedu.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SysSubject implements Serializable {

    /*
    * `SUBJECT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `SUBJECT_NAME` varchar(50) NOT NULL DEFAULT '' COMMENT '专业名称',
  `STATUS` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态 0:默认 1:删除',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `PARENT_ID` int(11) DEFAULT '0' COMMENT '父ID',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段',
  PRIMARY KEY (`SUBJECT_ID`)*/

    @Id
    @Column
    Integer subjectId;
    @Column
    String subjectName;
    @Column
    Integer status;
    @Column
    Date createTime;
    @Column
    Integer parentId;
    @Column
    Integer sort;

    @Transient
    List<SysSubject> children = new ArrayList<>();

    @Transient
    String name;

    @Transient
    boolean open;


}
