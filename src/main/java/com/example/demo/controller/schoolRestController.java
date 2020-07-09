package com.example.demo.controller;

import com.example.demo.mapper.SchoolMapper;
import com.example.demo.model.School;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class schoolRestController {
    @Autowired
    private SchoolMapper schoolMapper;

    //添加一个学校
    @RequestMapping("/rest/addschool")
    public String addschool(Integer scid,String name,String description,String schoolWeb)
    {
        //先查找
        School school = schoolMapper.getschool(name);
        if(school!=null)    //存在，不可添加
        {
            return "fault";
        }
        else
        {
            schoolMapper.addschool(scid, name, description, schoolWeb);
            return "add";
        }
    }


    //删除学校
    @RequestMapping("/rest/deleteschool")
    public String deleteschool(String name)
    {
        //先查找
        School school = schoolMapper.getschool(name);
        if(school!=null)    //有该学校，可以删除
        {
            schoolMapper.deleteschool(name);
            return "delete";
        }
        else
        {
            return "fault";
        }
    }


    //修改学校信息
    @RequestMapping("/rest/updateschool")
    public String updateschool(String name,String description,String schoolWeb)
    {
        //先查询
        School school = schoolMapper.getschool(name);
        if(school!=null)    //存在该学校，可以修改信息
        {
            schoolMapper.updateschool(name, description, schoolWeb);
            return "update";
        }
        else
        {
            return "fault";
        }
    }

    //得到一个学校，即查找学校
    @RequestMapping("/rest/getschool")
    public School getschool(String name)
    {
        School school = schoolMapper.getschool(name);
        return school;
    }

    //得到所有学校，即查询所有学校
    @RequestMapping("/rest/getallschool")
    public List<School> getallschool()
    {
        List<School> list = schoolMapper.getallschool();
        return list;
    }

}
