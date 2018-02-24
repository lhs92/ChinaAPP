package com.supermap.advisoryinfo.entity;

import java.util.Date;

/**
 * @Author:langhongshuai
 * @Description:
 * @Date:18/1/28 下午11:59
 */
public class Advisoryinfo {

    /**
     *咨询id
     */
    private int id;

    /**
     *用户id
     */
    private int userId;

    /**
     *服务器接受到咨询的时间
     */
    private Date updateTime;

    /**
     *发起咨询的地方
     */
    private String areacode;

    /**
     *咨询问题描述
     */
    private String question;

    /**
     *问题是否解决 0：未解决 ,1:解决
     */
    private int solved;

    /**
     *是否被删除,0:被删除，1:存在
     */
    private int existed;

    /**
     *数据是否审核过 0:未审核过 ，1：审核过了
     */
    private int checked;

    /**
     *该问题对应的学科分类
     */
    private int subjectid;

    /**
     *农田id
     */
    private int farmlandid;

    /**
     *中心点纬度
     */
    private String lat;

    /**
     *中心点经度
     */
    private String lon;

    /**
     *删除标识
     */
    private String del_flg;

    /**
     *删除用户标识别
     */
    private String del_user;

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getSolved() {
        return solved;
    }

    public void setSolved(int solved) {
        this.solved = solved;
    }

    public int getExisted() {
        return existed;
    }

    public void setExisted(int existed) {
        this.existed = existed;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public int getFarmlandid() {
        return farmlandid;
    }

    public void setFarmlandid(int farmlandid) {
        this.farmlandid = farmlandid;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDel_flg() {
        return del_flg;
    }

    public void setDel_flg(String del_flg) {
        this.del_flg = del_flg;
    }

    public String getDel_user() {
        return del_user;
    }

    public void setDel_user(String del_user) {
        this.del_user = del_user;
    }
}
