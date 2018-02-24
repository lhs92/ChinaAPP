package com.supermap.common.service;

import com.supermap.common.JSONUtil;

/**
 * @Author:langhongshuai
 * @Description:区域业务层
 * @Date:18/1/8 上午11:15
 */
public interface AreaService {

    /**
     * 获得所有的区域信息
     * @return
     */
    public JSONUtil getAllAreas();

    /**
     * 通过区域名获取区域信息
     * @param areaName
     * @return
     */
    public JSONUtil getAreaByName(String areaName);

}
