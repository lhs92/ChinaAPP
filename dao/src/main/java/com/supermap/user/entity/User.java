package com.supermap.user.entity;

import java.util.Date;

/**
 * @Author:langhongshuai
 * @Description:用户信息
 * @Date:18/1/3 上午10:39
 */
public class User {

    /**
     * 用户id
     */
    private int id;

    /**
     * 用户名
     */
    private String username;

    /**
     *登陆名
     */
    private String loginName;

    /**
     * 昵称
     */
    private String showName;

    /**
     *密码
     */
    private String password;

    /**
     *用户电话
     */
    private String mobile;

    /**
     *用户地址
     */
    private String address;

    /**
     *用户邮箱
     */
    private String Email;

    /**
     *用户状态
     */
    private String state;

    /**
     *用户头像
     */
    private String HeadImage;

    /**
     *用户介绍
     */
    private String Introduction;

    /**
     *用户区域code
     */
    private String areaCode;

    /**
     *用户是否删除
     */
    private String del_flg;

    /**
     *用户创建时间
     */
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getShowName() { return showName; }

    public void setShowName(String showName) { this.showName = showName; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHeadImage() {
        return HeadImage;
    }

    public void setHeadImage(String headImage) {
        HeadImage = headImage;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getDel_flg() {
        return del_flg;
    }

    public void setDel_flg(String del_flg) {
        this.del_flg = del_flg;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
