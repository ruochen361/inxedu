package com.atguigu.inxedu.bean;

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
public class EduUser implements Serializable {

    /*
    * `USER_ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '学员ID',
  `MOBILE` VARCHAR(11) DEFAULT NULL COMMENT '手机号',
  `EMAIL` VARCHAR(50) DEFAULT NULL COMMENT '邮箱号',
  `PASSWORD` VARCHAR(64) DEFAULT NULL COMMENT '密码',
  `USER_NAME` VARCHAR(50) DEFAULT NULL COMMENT '用户名',
  `SHOW_NAME` VARCHAR(50) DEFAULT NULL COMMENT '显示名 （昵称）',
  `SEX` TINYINT(1) DEFAULT '0' COMMENT '性别  1男  2女',
  `AGE` TINYINT(3) DEFAULT '0' COMMENT '年龄',
  `CREATE_TIME` TIMESTAMP NULL DEFAULT NULL COMMENT '注册时间',
  `IS_AVALIBLE` TINYINT(1) DEFAULT '1' COMMENT '是否可用 1正常  2冻结',
  `PIC_IMG` VARCHAR(255) DEFAULT NULL COMMENT '用户头像',
  `BANNER_URL` VARCHAR(200) DEFAULT NULL COMMENT '个人中心用户背景图片',
  `MSG_NUM` INT(11) DEFAULT '0' COMMENT '站内信未读消息数',
  `SYS_MSG_NUM` INT(11) DEFAULT '0',
  `LAST_SYSTEM_TIME` DATETIME DEFAULT '0000-00-00 00:00:00' COMMENT '上传统计系统消息时间',*/

    @Id
    @Column
    Integer userId;
    @Column
    String mobile;
    @Column
    String email;
    @Column
    String password;
    @Column
    String userName;
    @Column
    String showName;
    @Column
    Integer sex;
    @Column
    Integer age;
    @Column
    Date createTime;
    @Column
    Integer isAvalible;
    @Column
    String picImg;
    @Column
    String bannerUrl;
    @Column
    Integer msgNum;
    @Column
    Integer sysMsgNum;
    @Column
    Date lastSystemTime;
}
