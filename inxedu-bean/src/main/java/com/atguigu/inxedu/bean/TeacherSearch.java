package com.atguigu.inxedu.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * User: ruochen
 * Date:2018/5/13 0013
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TeacherSearch implements Serializable {

    String searchKey;

    Integer isStar;

    String minTime;

    String maxTime;
}
