package com.supermap.farmland.entity;

import com.supermap.mappoint.entity.Mappoint;

import java.util.Date;

/**
 * @Author:langhongshuai
 * @Description:农田类
 * @Date:18/1/28 下午10:54
 */
public class Farmland extends Mappoint {

    /**
     * 农田id
     */
    private int id;

    /**
     *用户id
     */
    private int userId;

    /**
     *工作站id
     */
    private int workStationID;

    /**
     *边界点
     */
    private String coordinates;

    /**
     *农田名称
     */
    private String descript;

    /**
     *海拔（乘以10按整数存储）
     */
    private int height;

    /**
     *中心点精度
     */
    private double longitude;

    /**
     *中心点纬度
     */
    private double latitude;

    /**
     *面积
     */
    private double area;
    /**
     *农田区域编号
     */
    private String code;

    /**
     *创建时间
     */
    private Date createtime;

    /**
     *删除标识
     */
    private int del_flg;

    /**
     *作物类型
     */
    private int crop;

    /**
     *作物名
     */
    private String name;



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

    public int getWorkStationID() {
        return workStationID;
    }

    public void setWorkStationID(int workStationID) {
        this.workStationID = workStationID;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getDel_flg() {
        return del_flg;
    }

    public void setDel_flg(int del_flg) {
        this.del_flg = del_flg;
    }

    public int getCrop() {
        return crop;
    }

    public void setCrop(int crop) {
        this.crop = crop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
