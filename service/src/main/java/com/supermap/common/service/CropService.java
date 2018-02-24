package com.supermap.common.service;

import com.supermap.common.JSONUtil;
import com.supermap.common.entity.Crop;

/**
 * @Author:langhongshuai
 * @Description:作物业务层
 * @Date:18/1/8 上午11:20
 */
public interface CropService {
    /**
     * 获得所有的区域信息
     * @return
     */
    public JSONUtil getAllCrops();

    /**
     * 保存作物
     * @return
     */
    public JSONUtil saveCrop(Crop crop);

    /**
     * 更新作物
     * @return
     */
    public JSONUtil updateCrop(Crop crop);

    /**
     * 删除作物
     * @return
     */
    public JSONUtil deleteCrop(String id);
}
