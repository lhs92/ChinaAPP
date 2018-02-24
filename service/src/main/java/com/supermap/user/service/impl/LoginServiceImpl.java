package com.supermap.user.service.impl;

import com.supermap.common.JSONUtil;
import com.supermap.common.MD5Util;
import com.supermap.user.dao.UserDao;
import com.supermap.user.entity.User;
import com.supermap.user.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:登陆业务逻辑层
 * @Date:18/1/9 下午3:08
 */
@Service
public class LoginServiceImpl implements LoginService{

    /**
     *使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Resource
    private UserDao userDao;

    //初始化MD5工具类
    private MD5Util md5Util = new MD5Util();

    @Override
    public JSONUtil login(String userName, String password) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
        password =  md5Util.EncoderByMd5(password);
        User user = userDao.Login(userName,password);
        if(user!=null){
            jsonUtil.setMsg("Login success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(user);
        }else{
            //重置密码失败后返回的json数据
            jsonUtil.setMsg("Login failed！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
//       logger.info("UserServiceImpl=>resetPassword=>fail");
        }
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("LoginServiceImpl=>login=>DaoException:"+e.getStackTrace());
            //重置密码失败后返回的json数据
            jsonUtil.setMsg("Login failed！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
//       logger.info("UserServiceImpl=>resetPassword=>fail");
        }

        return jsonUtil;
    }

    @Override
    public JSONUtil register(User user) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            user.setPassword(md5Util.EncoderByMd5(user.getPassword()));
            userDao.register(user.getUsername(),user.getPassword(),user.getLoginName(),user.getMobile(),user.getAreaCode());
            if(user!=null){
                jsonUtil.setMsg("register success！");
                jsonUtil.setIsSuccess(true);
                jsonUtil.setCode(200);
                jsonUtil.setData(user);
            }else{
                //重置密码失败后返回的json数据
                jsonUtil.setMsg("register failed！");
                jsonUtil.setIsSuccess(false);
                jsonUtil.setCode(100);
//       logger.info("UserServiceImpl=>resetPassword=>fail");
            }
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("LoginServiceImpl=>register=>DaoException:"+e.getStackTrace());
            //重置密码失败后返回的json数据
            jsonUtil.setMsg("register failed！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
//       logger.info("UserServiceImpl=>resetPassword=>fail");
        }
        return jsonUtil;
    }

    @Override
    public JSONUtil checkMobileAndLoginName(String account) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            List<User> users =userDao.checkMobileAndLoginName(account);
            if(users.size()!=0){
                jsonUtil.setMsg("Account is existed！");
                jsonUtil.setIsSuccess(false);
                jsonUtil.setCode(100);
            }else{
                //重置密码失败后返回的json数据
                jsonUtil.setMsg("Account is not existed！");
                jsonUtil.setIsSuccess(true);
                jsonUtil.setCode(200);
            }
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("LoginServiceImpl=>checkMobileAndLoginName=>DaoException:"+e.getStackTrace());
            //重置密码失败后返回的json数据
            jsonUtil.setMsg("checkMobileAndLoginName failed！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }
}
