package com.supermap.user.service.impl;

import com.supermap.common.JSONUtil;
import com.supermap.user.dao.RoleDao;
import com.supermap.user.entity.Role;
import com.supermap.user.entity.User;
import com.supermap.user.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:角色业务逻辑层
 * @Date:18/1/8 上午9:58
 */
@Service
public class RoleServiceImpl implements RoleService {

    /**
     *使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Resource
    private RoleDao roleDao;

    @Override
    public JSONUtil getAllRoles(){
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            List<Role>  roles = roleDao.getAllRoles();

            //获取所有的用户角色后返回的json数据
            jsonUtil.setMsg("Get all roles success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(roles);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("RoleServiceImpl=>getAllRoles=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Get all roles flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }
}
