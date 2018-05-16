package com.atguigu.inxedu.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * User: ruochen
 * Date:2018/5/13 0013
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UserSearch implements Serializable {

    String searchKey;

    Integer isAvalible;

    String minTime;

    String maxTime;
}
