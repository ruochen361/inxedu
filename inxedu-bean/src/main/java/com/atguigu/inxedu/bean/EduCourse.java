package com.atguigu.inxedu.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * User: ruochen
 * Date:2018/5/14 0014
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class EduCourse implements Serializable {

    /*`COURSE_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `COURSE_NAME` varchar(300) NOT NULL DEFAULT '' COMMENT '课程名称',
  `IS_AVALIABLE` int(10) NOT NULL DEFAULT '0' COMMENT '1正常2删除',
  `SUBJECT_ID` int(11) DEFAULT '0' COMMENT '课程专业ID',
  `SUBJECT_LINK` varchar(255) DEFAULT NULL COMMENT '课程专业链',
  `ADD_TIME` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `SOURCE_PRICE` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '课程原价格（只显示）',
  `CURRENT_PRICE` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '课程销售价格（实际支付价格）设置为0则可免费观看',
  `TITLE` varchar(200) NOT NULL DEFAULT '' COMMENT '课程简介',
  `CONTEXT` longtext NOT NULL COMMENT '课程详情',
  `LESSION_NUM` int(11) NOT NULL DEFAULT '0' COMMENT '总课时',
  `LOGO` varchar(200) NOT NULL DEFAULT '' COMMENT '图片路径',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
  `PAGE_BUYCOUNT` int(11) DEFAULT '0' COMMENT '销售数量',
  `PAGE_VIEWCOUNT` int(11) NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `END_TIME` timestamp NULL DEFAULT NULL COMMENT '有效结束时间',
  `LOSETYPE` int(2) DEFAULT '0' COMMENT '有效期类型，0：到期时间，1：按天数',
  `LOSE_TIME` varchar(255) DEFAULT NULL COMMENT '有效期:商品订单过期时间点',
  `SEQUENCE` int(1) DEFAULT '0' COMMENT '序列',
  `COURSE_GROSS_INCOME` decimal(10,2) DEFAULT '0.00' COMMENT '该课程总共卖了多少钱（新加字段暂时没用到）',
    * */
    @Id
            @Column
    Integer courseId;
    @Column
    String courseName;
    @Column
    Integer isAvaliable;
    @Column
    Integer subjectId;
    @Column
    String  subjectLink;
    @Column
    Date addTime;
    @Column
    BigDecimal sourcePrice;
    @Column
    BigDecimal currentPrice;
    @Column
    String title;
    @Column
    String context;
    @Column
    Integer lessionNum;
    @Column
    String logo;
    @Column
    Date updateTime;
    @Column
    Integer pageBuycount;
    @Column
    Integer pageViewcount;
    @Column
    Date endTime;
    @Column
    Integer losetype;
    @Column
    String loseTime;
    @Column
    Integer sequence;
    @Column
    BigDecimal courseGrossIncome;

    @Transient
    String subjectName;

    @Transient
    List<EduTeacher> teacherList;

}
