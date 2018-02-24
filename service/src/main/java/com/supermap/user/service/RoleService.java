package com.supermap.user.service;

import com.supermap.common.JSONUtil;

/**
 * @Author:langhongshuai
 * @Description:角色业务层
 * @Date:18/1/8 上午9:55
 */
public interface RoleService {

    /**
     * 获得所有的用户角色
     * @return
     */
    public JSONUtil getAllRoles();
}
