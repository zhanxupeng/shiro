package com.smart.dao;

import com.smart.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 占大帅 on 2017/7/8.
 */
@Repository
public interface RoleMapper {
    /**
     * 查询一个用户的所有角色
     * @param userid
     * @return
     */
    @Select("select * from role where id in (select roleid from userrole where userid=#{userid})")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "description",property = "description")
    })
    List<Role> selectByUserId(@Param("userid") int userid);
}
