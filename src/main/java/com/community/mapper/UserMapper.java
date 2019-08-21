package com.community.mapper;

import com.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Com.OceanLee
 * @date 2019/8/21 18:03
 * 获取GitHub用户信息 并插入到数据库
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    //因为是接口 所以默认访问修饰符是public  可以不写
    void insert(User user);

}
