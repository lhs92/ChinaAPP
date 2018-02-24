package com.supermap.mappoint.service;

import com.supermap.common.JSONUtil;
import com.supermap.mappoint.entity.Mappoint;

import java.nio.MappedByteBuffer;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description: 地图点位业务层
 * @Date:18/1/26 下午5:34
 */
public interface MappointService {

    /**
     * 获取所有的地图点信息
     * @return
     */
    public JSONUtil getAllMappoints();
}
