package com.community.mapper;

import com.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author Com.OceanLee
 * @date 2019/8/21 18:03
 */
@Mapper
public interface UserMapper {

    /**
     *  * 获取GitHub用户信息 并插入到数据库
     * @param user
     */
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    //因为是接口 所以默认访问修饰符是public  可以不写
    void insert(User user);

    @Select("select * from user where token =#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id =#{id}")
    User findById(@Param("id")Integer id);

    @Select("select * from user where account_id =#{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    //更新、
    @Update("update user set name=#{name},token=#{token},gmt_modified =#{gmtModified},avatar_url=#{avatarUrl} where id =#{id}")
    void update(User user);
}
