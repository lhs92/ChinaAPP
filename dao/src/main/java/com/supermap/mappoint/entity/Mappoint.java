package com.supermap.mappoint.entity;

/**
 * @Author:langhongshuai
 * @Description:地图点类
 * @Date:18/1/26 下午5:49
 */
public class Mappoint {

    /**
     * 地图点类id
     */
    private int id;

    /**
     * 地图点类名
     */
    private String name;

    /**
     * 地图点类code
     */
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
