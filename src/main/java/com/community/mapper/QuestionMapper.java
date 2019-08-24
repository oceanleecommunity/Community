package com.community.mapper;

import com.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Com.OceanLee
 * @date 2019/8/21 22:17
 */
@Mapper
public interface QuestionMapper {
    @Insert("INSERT INTO question(title,description,gmt_create,gmt_modified,creator,tag) VALUES(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{creator})")
     void create(Question question);

    @Select("select * from question")
    List<Question> list();
}
