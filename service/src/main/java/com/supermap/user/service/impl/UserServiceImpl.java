package com.supermap.user.service.impl;

import com.supermap.common.JSONUtil;
import com.supermap.common.MD5Util;
import com.supermap.user.dao.UserDao;
import com.supermap.user.entity.Role;
import com.supermap.user.entity.User;
import com.supermap.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:用户业务逻辑层
 * @Date:18/1/3 下午4:23
 */
@Service
@CacheConfig(cacheNames="userCache") // 本类内方法指定使用缓存时，默认的名称就是userCache
@Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {

    /**
     *使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    //初始化MD5工具类
    private MD5Util md5Util = new MD5Util();

    // 因为必须要有返回值，才能保存到数据库中，如果保存的对象的某些字段是需要数据库生成的，
    //那保存对象进数据库的时候，就没必要放到缓存了
    @Override
    @CachePut(key="#p0.loginName")  //#p0表示第一个参数
    //必须要有返回值，否则没数据放到缓存中
    public User insertUser(User u){
        this.userDao.insert(u);
        //u对象中可能只有只几个有效字段，其他字段值靠数据库生成，比如id
        return this.userDao.find(u.getLoginName());
    }

    @Override
    public JSONUtil findUserByAreaRId(String areaCode, int RoleId) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            List<User> users = userDao.findUserByAreaRId(areaCode,RoleId);

            //通过地区和角色后返回用户信息
            jsonUtil.setMsg("Get users success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(users);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("RoleServiceImpl=>getAllRoles=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Get users flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }

    @Override
    public JSONUtil resetPassword(String userName, String oldPassword,String newPassword) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        //给密码加密
        String md5OldPassword = null;
        String md5NewPassword = null;
        try {
            md5OldPassword = md5Util.EncoderByMd5(oldPassword);
            md5NewPassword = md5Util.EncoderByMd5(newPassword);
            //通过用户名和密码检查用户是否存在
        } catch (NoSuchAlgorithmException e) {
            logger.error("UserServiceImpl=>resetPassword=>NoSuchAlgorithmException:"+e.getStackTrace());
        } catch (UnsupportedEncodingException e) {
            logger.error("UserServiceImpl=>resetPassword=>UnsupportedEncodingException:"+e.getStackTrace());
        }

        try {
            User user = userDao.checkUserByUP(userName,md5OldPassword);
            if(user!=null){
                //重置密码
                userDao.resetPassword(userName,md5NewPassword);
                //重置密码成功后返回的json数据
                jsonUtil.setMsg("Reset password success！");
                jsonUtil.setIsSuccess(true);
                jsonUtil.setCode(200);
            }else{
                //重置密码失败后返回的json数据
                jsonUtil.setMsg("Reset password failed！");
                jsonUtil.setIsSuccess(false);
                jsonUtil.setCode(100);
            }
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("UserServiceImpl=>resetPassword=>DaoException:"+e.getStackTrace());
            //重置密码失败后返回的json数据
            jsonUtil.setMsg("Reset password failed！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }

        return jsonUtil;
    }
}
