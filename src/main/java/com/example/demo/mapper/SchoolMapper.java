package com.example.demo.mapper;

import com.example.demo.model.School;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchoolMapper {
    /*
    private Integer scid;         //主键
    private String name;          //学校名称
    private String description;   //简介描述
    private String schoolWeb;     //学校官网
    * */

    //增删改查
    //添加学校
    @Insert("insert into school (scid,name,description,schoolWeb) values (#{scid},#{name},#{description},#{schoolWeb})")
    void addschool(Integer scid,String name,String description,String schoolWeb);

    //删除学校
    @Delete("delete from school where name=#{name}")
    void deleteschool(String name);

    //修改学校信息
    @Update("update school set description=#{description},schoolWeb=#{schoolWeb} where name=#{name}")
    void updateschool(String name,String description,String schoolWeb);

    //查询一所高校，即得到一所高校
    @Select("select * from school where name=#{name}")
    School getschool(String name);

    //查询所有学校
    @Select("select * from school")
    List<School> getallschool();

}
