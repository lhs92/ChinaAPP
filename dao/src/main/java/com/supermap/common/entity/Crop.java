package com.supermap.common.entity;

import java.util.Date;

/**
 * @Author:langhongshuai
 * @Description:作物类
 * @Date:18/1/8 上午11:37
 */
public class Crop {

    /**
     * 作物id
     */
    private String id;

    /**
     *所属部门
     */
    private String sys_org_code;

    /**
     *所属公司
     */
    private String sys_company_code;

    /**
     *字典编码
     */
    private String code;

    /**
     *字典名称
     */
    private String name;

    /**
     *描述
     */
    private String description;

    /**
     *字典级别
     */
    private int levels;

    /**
     *一级编码
     */
    private String root_code;

    /**
     *父ID
     */
    private String parentid;

    /**
     *序号
     */
    private int sequence;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSys_org_code() {
        return sys_org_code;
    }

    public void setSys_org_code(String sys_org_code) {
        this.sys_org_code = sys_org_code;
    }

    public String getSys_company_code() {
        return sys_company_code;
    }

    public void setSys_company_code(String sys_company_code) {
        this.sys_company_code = sys_company_code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public String getRoot_code() {
        return root_code;
    }

    public void setRoot_code(String root_code) {
        this.root_code = root_code;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
