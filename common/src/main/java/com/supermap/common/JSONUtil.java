package com.supermap.common;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @Author:langhongshuai
 * @Description:json封装工具类
 * @Date:18/1/4 下午4:45
 */
public class JSONUtil {
    //是否成功
    private boolean isSuccess = true;

    //提示信息
    private String msg = "操作成功";

    //返回的数据
    private Object data = null;

    //失败：100
    //成功：200
    private Integer code = 200;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获得json字符串
     * @return
     */
    public String getJsonStr(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSuccess", this.getIsSuccess());
        jsonObject.put("msg", this.getMsg());
        jsonObject.put("data", this.data);
        jsonObject.put("code",this.code);
        return jsonObject.toJSONString();
    }
}
