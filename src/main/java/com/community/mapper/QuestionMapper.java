package com.community.mapper;

import com.community.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Com.OceanLee
 * @date 2019/8/21 22:17
 */
@Mapper
public interface QuestionMapper {
    //获取GitHub用户信息 插入到数据库
    @Insert("INSERT INTO question(title,description,gmt_create,gmt_modified,creator,tag) VALUES(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{creator})")
     void create(Question question);

    //分页查询发布得问题
    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    //查询总数
    @Select("select count(1) from question")
    Integer count();

    //根据ID 查询用户问题
    @Select("select * from question  where creator =#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") Integer userId,@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    //根据用户ID查询 发布得问题
    @Select("select count(1) from question where creator =#{userId}")
    Integer countByUserId(@Param("userId")Integer userId);

    //根据 ID 查询相对应得问题
    @Select("select * from question  where id =#{id}")
    Question getById(@Param("id")Integer id);

    //修改问题
    @Update("update question set title =#{title},description =#{description},gmt_modified=#{gmtModified},tag=#{tag} where id =#{id}")
    void update(Question question);
}
