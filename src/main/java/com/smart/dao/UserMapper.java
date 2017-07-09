package com.smart.dao;

import com.smart.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;


/**
 * Created by 占大帅 on 2017/7/8.
 */
@Repository
public interface UserMapper {
    /**
     * 根据用户名查询用户的所有信息
     * @param username
     * @return
     */
    @Select("select * from tb_user where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "isDelete",property = "isDelete"),
            @Result(column = "createDate",property = "createDate"),
            @Result(column = "id",property = "userRoles",
            many = @Many(select="com.smart.dao.RoleMapper.selectByUserId",fetchType = FetchType.LAZY))
    })
    User selectUserByName(@Param("username") String username);
}
