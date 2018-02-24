package com.supermap.user.controller;

import com.supermap.common.JSONUtil;
import com.supermap.user.entity.User;
import com.supermap.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:langhongshuai
 * @Description:用户接口层
 * @Date:18/1/3 下午4:08
 */
@Controller
@RequestMapping("UserController")
public class UserController {
    /**
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);

   @Autowired
   private UserService userService;

    /**
     * 用户注册
     */
    @RequestMapping("/register")
    public void register(){

    }

    /**
     * 合法性Check
     */
    @RequestMapping("checkUser")
    public void checkUser(){

    }

    /**
     * 头像上传
     */
    @RequestMapping("headImgUpLoad")
    public void headImgUpload(){

    }

    /**
     *密码重置
     * @param request
     */
    @RequestMapping("resetPassword")
    @ResponseBody
    public JSONUtil resetPassword(HttpServletRequest request){
        //获取用户名、旧密码以及新密码
        String userName = request.getParameter("userName");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        if((userName == null&&oldPassword == null && newPassword == null)||(userName.isEmpty()&&oldPassword.isEmpty()&& newPassword .isEmpty())){
            JSONUtil jsonUtil = new JSONUtil();
            logger.info("userController=>resetPassword=>AllParameter=>null");
            jsonUtil.setMsg("Reset password failed！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
            return jsonUtil;
        }
        return userService.resetPassword(userName,oldPassword,newPassword);

    }

    /**
     *通过Id查询用户
     */
    @RequestMapping("queryUserById")
    public void queryUser(){

    }

    /**
     *增加用户
     */
    @RequestMapping("insertUser")
    public void insertUser(HttpServletRequest request){
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String areaCode = request.getParameter("areaCode");
        String realName = request.getParameter("realName");
        User user = new User();
        user.setLoginName(loginName);
        user.setUsername(realName);
        user.setPassword(password);
        user.setAreaCode(areaCode);
        user.setMobile(mobile);
        userService.insertUser(user);
    }

    /**
     *通过角色id和区域获取用户信息
     */
    @RequestMapping("findUserByAreaRId")
    @ResponseBody
    public JSONUtil findUserByAreaRId(HttpServletRequest request){
        String areaCode=request.getParameter("areaCode");
        String roleId = request.getParameter("roleId");
        return userService.findUserByAreaRId(areaCode,Integer.valueOf(roleId));
    }


}
