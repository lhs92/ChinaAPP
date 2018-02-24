package com.supermap.common.entity;

import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:区域类
 * @Date:18/1/8 上午11:33
 */
public class Area {
    /**
     * 区域id
     */
    private int areaid;

    /**
     * 区域code
     */
    private String areaCode;

    /**
     * 区域名
     */
    private String areaName;

    /**
     * 区域拼音
     */
    private String enName;

    /**
     * 区域中心点经度
     */
    private double longitude;

    /**
     *子节点
     */
    private List<Area> childNode;

    /**
     * 区域中心点纬度
     */
    private double latitude;

    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
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

    public List<Area> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<Area> childNode) {
        this.childNode = childNode;
    }
}
