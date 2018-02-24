package com.supermap.user.dao;

import com.supermap.user.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:角色数据访问层
 * @Date:18/1/8 上午10:41
 */
@Mapper
public interface RoleDao {

    /**
     * 获得所有的用户角色
     * @return
     */
    @Select("select * from t_role")
    public List<Role> getAllRoles();

}
