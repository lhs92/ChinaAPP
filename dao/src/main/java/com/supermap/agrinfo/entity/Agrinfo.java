package com.supermap.agrinfo.entity;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @Author:langhongshuai
 * @Description:农情信息类
 * @Date:18/1/29 下午2:43
 */
public class Agrinfo {

    /**
     * 农情id
     */
    private int id;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 农田id
     */
    private int farm;

    /**
     *图片上传时间
     */
    private Date uploadTime;

    /**
     *种养品种，关联t_CropsType
     */
    private int type;

    /**
     *种养类型，关联t_CropsType
     */
    private int breed;

    /**
     *作物生育期,关联t_AgrWeaQuota
     */
    private int growthperiod;

    /**
     *拍照所在地经度
     */
    private String  longitude;

    /**
     *拍照所在地纬度
     */
    private String latitude;

    /**
     *区划编码
     */
    private String areacode;

    /**
     *农情描述
     */
    private String descript;

    /**
     *删除标识（0:未删除 1:删除）
     */
    private String del_flg;

    /**
     *删除用户id
     */
    private int del_user;

    /**
     * 创建时间
     */
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBreed() {
        return breed;
    }

    public void setBreed(int breed) {
        this.breed = breed;
    }

    public int getGrowthperiod() {
        return growthperiod;
    }

    public void setGrowthperiod(int growthperiod) {
        this.growthperiod = growthperiod;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getDel_flg() {
        return del_flg;
    }

    public void setDel_flg(String del_flg) {
        this.del_flg = del_flg;
    }

    public int getDel_user() {
        return del_user;
    }

    public void setDel_user(int del_user) {
        this.del_user = del_user;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
