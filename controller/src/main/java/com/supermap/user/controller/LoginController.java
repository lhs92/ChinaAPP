package com.supermap.user.controller;

import com.supermap.common.JSONUtil;
import com.supermap.user.entity.User;
import com.supermap.user.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:langhongshuai
 * @Description:登陆接口层
 * @Date:18/1/9 下午2:14
 */
@Controller
@RequestMapping("LoginController")
public class LoginController {
    /**
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    /**
     * 登陆
     * @param request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public JSONUtil login(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        //获得参数
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //判断参数是否为空
        if((userName == null&& password == null)||(userName.isEmpty()&& password.isEmpty())){
            JSONUtil jsonUtil = new JSONUtil();
            logger.info("LoginController=>login=>AllParameter=>null");
            jsonUtil.setMsg("Login failed！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
            return jsonUtil;
        }
        return loginService.login(userName,password);
    }

    /**
     * 注册
     * @param request
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public JSONUtil register(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        //获得参数
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String areaCode = request.getParameter("areaCode");
        String realName = request.getParameter("realName");
        //判断参数是否为空
        if((loginName == null&& password == null && mobile == null&&areaCode==null && realName==null)
                ||(loginName.isEmpty()&& password.isEmpty()&&mobile.isEmpty()&&areaCode.isEmpty()&&realName.isEmpty())){
            JSONUtil jsonUtil = new JSONUtil();
            logger.info("LoginController=>register=>AllParameter=>null");
            jsonUtil.setMsg("register failed！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
            return jsonUtil;
        }
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setMobile(mobile);
        user.setAreaCode(areaCode);
        user.setUsername(realName);
        return loginService.register(user);
    }

    /**
     * 检查账户名（电话号码或登录名）是否已经存在
     * @param request
     * @return
     */
    @RequestMapping("/checkMobileAndLoginName")
    @ResponseBody
    public JSONUtil checkMobileAndLoginName(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        //获得参数
        String acount = request.getParameter("acount");
        //判断参数是否为空
        if(acount == null ||acount.isEmpty()){
            JSONUtil jsonUtil = new JSONUtil();
            logger.info("LoginController=>checkMobileAndLoginName=>AllParameter=>null");
            jsonUtil.setMsg("checkMobileAndLoginName failed！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
            return jsonUtil;
        }
        return loginService.checkMobileAndLoginName(acount);
    }


}
