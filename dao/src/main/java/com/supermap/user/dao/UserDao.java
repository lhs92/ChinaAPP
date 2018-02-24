package com.supermap.user.dao;

import com.supermap.user.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:用户数据访问层
 * @Date:18/1/3 上午10:42
 */
@Mapper
public interface UserDao {

    /**
     * 通过用户名和密码获取用户信息
     * @param userName
     * @param password
     * @return
     */
    @Select("select * from t_user t1 where t1.loginName=#{userName} and t1.password=#{password}")
    public User checkUserByUP(@Param("userName") String userName, @Param("password") String password);

    /**
     * 通过用户名重置密码
     * @param userName
     * @param newPassword
     */
    @Select("update t_user set password =#{newPassword} where username=#{userName}")
    public void resetPassword(@Param("userName") String userName,@Param("newPassword") String newPassword);

    /**
     *通过（帐号或手机号）和密码登陆
     * @param userName
     * @param password
     * @return
     */
    @Select("select * from t_user t1 where (t1.loginName =#{userName} or t1.mobile =#{userName})and t1.password=#{password}")
    public User Login(@Param("userName") String userName,@Param("password") String password);

    /**
     * 全国APP注册
     * @param userName
     * @param password
     * @param loginName
     * @param mobile
     * @param areaCode
     */
    @Insert("Insert into t_user(username,password,loginName,mobile,areaCode) values(#{userName},#{password},#{loginName},#{mobile},#{areaCode})")
    public void register(@Param("userName") String userName,@Param("password") String password,@Param("loginName") String loginName,@Param("mobile") String mobile,@Param("areaCode") String areaCode);

    /**
     * 通过账户名查找用户
     * @param account
     * @return
     */
    @Select("Select * from t_user t1 where t1.loginName =#{account} or t1.mobile =#{account}")
    public List<User> checkMobileAndLoginName(@Param("account") String account);

    /**
     *增加用户
     * @param u
     */
    @Insert("Insert into t_user(username,password,loginName,mobile,areaCode) values(#{username},#{password},#{loginName},#{mobile},#{areaCode})")
    public void insert(User u);

    /**
     * 通过登录名查找用户
     * @param loginName
     * @return
     */
    @Select("select id,username from t_user where loginName=#{loginName} ")
    public User find(@Param("loginName")String loginName);

    /**
     * 通过登录名查找用户
     * @param id
     * @return
     */
    @Select("select * from t_user where id=#{id} ")
    public User findUserById(@Param("id")String id);

    /**
     * 通过区域code和角色获取用户信息
     * @param areaCode
     * @param roleId
     * @return
     */
    @Select("select t1.id,t1.username,t1.address,t1.HeadImage,t1.Introduction from t_user t1 \n" +
            "INNER JOIN t_user_role t2\n" +
            "on t1.id=t2.userid\n" +
            "where \n" +
            "IF(ISNULL(#{areaCode}),true,t1.areaCode=#{areaCode} and t2.roleid=#{roleId});")
    public List<User> findUserByAreaRId(@Param("areaCode")String areaCode,@Param("roleId")int roleId);
}
