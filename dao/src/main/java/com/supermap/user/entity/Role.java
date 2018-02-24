package com.supermap.user.entity;

/**
 * @Author:langhongshuai
 * @Description:角色信息
 * @Date:18/1/8 上午10:13
 */
public class Role {
    /**
     * 角色Id
     */
    private int id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 删除标识
     */
    private int delFlg;

    /**
     * 角色Code
     */
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(int delFlg) {
        this.delFlg = delFlg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
