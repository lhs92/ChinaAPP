package com.supermap.user.controller;

import com.supermap.common.JSONUtil;
import com.supermap.user.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:langhongshuai
 * @Description: 角色接口层
 * @Date:18/1/8 上午9:43
 */
@Controller
@RequestMapping("RoleController")
public class RoleController {
    /**
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 角色获取
     */
    @RequestMapping("/getAllRoles")
    @ResponseBody
    public JSONUtil getAllRoles(){
       return roleService.getAllRoles();
    }

}
