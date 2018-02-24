package com.supermap.user.service;

import com.supermap.common.JSONUtil;
import com.supermap.user.entity.User;

/**
 * @Author:langhongshuai
 * @Description:登陆业务层
 * @Date:18/1/9 下午3:08
 */
public interface LoginService {

    /**
     * 登陆
     * @param userName
     * @param password
     * @return
     */
    public JSONUtil login(String userName,String password);

    /**
     * 注册
     * @param user
     * @return
     */
    public JSONUtil register(User user);

    /**
     * 检查账户名（电话号码或登录名）是否已经存在
     * @param account
     * @return
     */
    public JSONUtil checkMobileAndLoginName(String account);
}
