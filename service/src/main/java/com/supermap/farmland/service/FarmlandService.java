package com.supermap.farmland.service;

import com.supermap.common.JSONUtil;
import com.supermap.farmland.entity.Farmland;

/**
 * @Author:langhongshuai
 * @Description:
 * @Date:18/1/29 上午9:35
 */
public interface FarmlandService {

    /**
     *通过用户id获取农田
     * @return
     */
    public JSONUtil getFarmlandByUIdArea(String userId,String areaCode);

    /**
     *添加农田
     * @param farmland
     * @return
     */
    public JSONUtil addFarmland(Farmland farmland);
}
