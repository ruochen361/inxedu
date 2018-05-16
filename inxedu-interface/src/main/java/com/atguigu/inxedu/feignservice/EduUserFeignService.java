package com.atguigu.inxedu.feignservice;

import com.atguigu.inxedu.bean.EduUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient("inxedu-student")
public interface EduUserFeignService {

    @RequestMapping("/user/list")
    public List<EduUser> getUserList();

    @RequestMapping("/user/search")
    public List<EduUser> searchUserList(@RequestBody Map<String, Object> paramMap);

    @RequestMapping("user/updateAvalible/{userId}")
    public void updateAvalible(@PathVariable("userId") String userId);

    @RequestMapping("/user/updatePassword")
    public void updatePassWord(@RequestBody Map<String, String> paramMap);
}
