package com.atguigu.inxedu.controller;

import com.atguigu.inxedu.bean.*;
import com.atguigu.inxedu.beanutil.AjaxResult;
import com.atguigu.inxedu.feignservice.CourseFeignService;
import com.atguigu.inxedu.feignservice.TeacherFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: ruochen
 * Date:2018/5/12 0012
 */
@Controller
public class TeacherConsumerController {

    @Autowired
    private TeacherFeignService teacherFeignService;


    @Autowired
    private CourseFeignService courseFeignService;


    @RequestMapping("/teacher/list")
    public String getTeacherList(Model model){
        List<EduTeacher> teacherList = teacherFeignService.getTeacherList();
        model.addAttribute("teacherList",teacherList);
        return "teacher";
    }

    @RequestMapping("/teacher/toAdd")
    public String toAdd(Model model){

        List<SysSubject> sysSubjectList = courseFeignService.getSubjectList();
        model.addAttribute("sysSubjectList",sysSubjectList);
        return "add";
    }

    @RequestMapping(value = "/teacher/toUpdate")
    public String toUpdate(String id, Model model){

        List<SysSubject> sysSubjectList = courseFeignService.getSubjectList();
        model.addAttribute("sysSubjectList",sysSubjectList);

        EduTeacher teacher = teacherFeignService.getTeacher(id);
        model.addAttribute("teacher",teacher);
        return "update";
    }



    @RequestMapping(value = "/teacher/search",method = RequestMethod.POST)
    @ResponseBody
    public Object searchTeacherList(TeacherSearch teacherSearch)  {
        AjaxResult ajaxResult = new AjaxResult();
        Map<String,Object> paramMap = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (teacherSearch.getSearchKey()!=""){
            paramMap.put("searchKey",teacherSearch.getSearchKey());
        }
        try {
            if (teacherSearch.getMinTime()!=""){

                Date minTime = dateFormat.parse(teacherSearch.getMinTime());
                paramMap.put("minTime",teacherSearch.getMinTime());
            }
            if (teacherSearch.getMaxTime()!=""){
                Date maxTime = dateFormat.parse(teacherSearch.getMaxTime());
                paramMap.put("maxTime",teacherSearch.getMaxTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paramMap.put("isStar",teacherSearch.getIsStar());

        try {
            List<EduTeacher> teacherList = teacherFeignService.searchTeacherList(paramMap);

            ajaxResult.setTeacherList(teacherList);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return  ajaxResult;
    }



    @ResponseBody
    @RequestMapping("/teacher/doAdd")
    public Object doAdd(HttpServletRequest request, EduTeacher eduTeacher, HttpSession session) {

        AjaxResult result = new AjaxResult();

        try {
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)request;
            //获取文件
            MultipartFile mfile = mreq.getFile("teacherPic");
            //获取文件名
            String name = mfile.getOriginalFilename();//java.jpg
            //获取文件名后缀
            String extname = name.substring(name.lastIndexOf(".")); // .jpg
            //创建新文件名
            String iconpath = UUID.randomUUID().toString()+extname; //232243343.jpg

            ServletContext servletContext = session.getServletContext();
            String realpath = servletContext.getRealPath("/picture");
            //拼接文件真实地址
            String path =realpath+ "\\teacher\\"+iconpath;
            //将文件上传至本地
            mfile.transferTo(new File(path));

            eduTeacher.setPicPath("/picture/teacher/"+iconpath);
            eduTeacher.setCreateTime(new Date());
            teacherFeignService.saveTeacher(eduTeacher);

            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/teacher/doUpdate")
    public Object doUpdate(HttpServletRequest request, EduTeacher eduTeacher, HttpSession session) {

        AjaxResult result = new AjaxResult();

        try {
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)request;
            //获取文件
            MultipartFile mfile = mreq.getFile("teacherPic");
            if (mfile!=null){
                //获取文件名
                String name = mfile.getOriginalFilename();//java.jpg
                //获取文件名后缀
                String extname = name.substring(name.lastIndexOf(".")); // .jpg
                //创建新文件名
                String iconpath = UUID.randomUUID().toString()+extname; //232243343.jpg

                ServletContext servletContext = session.getServletContext();
                String realpath = servletContext.getRealPath("/picture");
                //拼接文件真实地址
                String path =realpath+ "\\teacher\\"+iconpath;
                //将文件上传至本地
                mfile.transferTo(new File(path));

                eduTeacher.setPicPath("/picture/teacher/"+iconpath);
            }

            eduTeacher.setUpdateTime(new Date());
            teacherFeignService.updateTeacher(eduTeacher);

            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/teacher/querylist")
    public Object queryList(@RequestParam(value="pageno", required=false,defaultValue="1" ) String pageno,
                            @RequestParam(value="pagesize",required=false,defaultValue="5")String pagesize,
                            TeacherSearch teacherSearch){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            Map<String,Object> paramMap = new HashMap();
            paramMap.put("pageno", pageno);
            paramMap.put("pagesize", pagesize);
            if (teacherSearch.getSearchKey()!=""){
                paramMap.put("searchKey",teacherSearch.getSearchKey());
            }
            if (teacherSearch.getMinTime()!=""){
                paramMap.put("minTime",teacherSearch.getMinTime());
            }
            if (teacherSearch.getMaxTime()!=""){
                paramMap.put("maxTime",teacherSearch.getMaxTime());
            }
            paramMap.put("isStar", teacherSearch.getIsStar());
            Page<EduTeacher> page = teacherFeignService.queryPage(paramMap);
            ajaxResult.setTeacherPage(page);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return  ajaxResult;

    }
}
