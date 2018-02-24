package com.supermap.user.service;

import com.supermap.common.JSONUtil;
import com.supermap.user.entity.User;

/**
 * @Author:langhongshuai
 * @Description:用户业务层
 * @Date:18/1/3 下午4:22
 */
public interface UserService {

    /**
     * 重置密码
     * @param userName
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public JSONUtil resetPassword(String userName, String oldPassword,String newPassword);

    /**
     * 添加用户
     * @param u
     * @return
     */
    public User insertUser(User u);

    /**
     *  通过区域code和用户id查找用户信息
     * @param areaCode
     * @param RoleId
     * @return
     */
    public JSONUtil findUserByAreaRId(String areaCode,int RoleId);
}
