package com.supermap.agrinfo.service;

import com.supermap.agrinfo.entity.Agrinfo;
import com.supermap.common.JSONUtil;

/**
 * @Author:langhongshuai
 * @Description:农田业务层
 * @Date:18/1/29 下午3:00
 */
public interface AgrinfoService {

    /**
     * 获取用户的所有农情信息
     * @param userId
     * @return
     */
    public JSONUtil getAgrinfoByUIdArea(String userId,String areaCode);

    /**
     * 增加农情或者灾情
     * @param agrinfo
     * @return
     */
    public JSONUtil addAgrinfoOrDisasterInfo(Agrinfo agrinfo);
}
