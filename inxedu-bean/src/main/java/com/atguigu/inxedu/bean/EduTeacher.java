package com.atguigu.inxedu.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class EduTeacher implements Serializable {

    /*
    * `ID` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '教师ID',
  `NAME` VARCHAR(12) NOT NULL DEFAULT '' COMMENT '教师名称',
  `EDUCATION` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '教师资历,一句话说明老师',
  `CAREER` TEXT NOT NULL COMMENT '教师简介',
  `IS_STAR` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '头衔 1高级讲师2首席讲师',
  `PIC_PATH` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '图片路径',
  `STATUS` TINYINT(3) NOT NULL DEFAULT '0' COMMENT '状态:0正常1删除',
  `CREATE_TIME` DATETIME DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` DATETIME DEFAULT NULL COMMENT '更新时间',
  `SUBJECT_ID` INT(11) DEFAULT '0' COMMENT '专业ID',
  `SORT` INT(11) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`ID`),
  KEY `NAME` (`NAME`)*/

    @Id
    @Column
    Integer id;
    @Column
    String name;
    @Column
    String education;
    @Column
    String career;
    @Column
    Integer isStar;
    @Column
    String picPath;
    @Column
    Integer status;
    @Column
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    Date createTime;
    @Column
    Date updateTime;
    @Column
    Integer subjectId;
    @Column
    Integer sort;

}
