package com.community.mapper;

import com.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Com.OceanLee
 * @date 2019/8/21 18:03
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id =#{id}")
    User findById(@Param("id")Integer id);
    /**
     *  * 获取GitHub用户信息 并插入到数据库
     * @param user
     */
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    //因为是接口 所以默认访问修饰符是public  可以不写
    void insert(User user);

    @Select("select * from user where token =#{token}")
    User findByToken(@Param("token") String token);
}
