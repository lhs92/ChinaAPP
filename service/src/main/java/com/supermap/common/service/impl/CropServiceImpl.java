package com.supermap.common.service.impl;

import com.supermap.common.JSONUtil;
import com.supermap.common.dao.CropDao;
import com.supermap.common.entity.Crop;
import com.supermap.common.service.CropService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:作物业务逻辑层
 * @Date:18/1/8 上午11:20
 */
@Service
public class CropServiceImpl implements CropService {
    /**
     *使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(CropServiceImpl.class);

    @Resource
    private CropDao cropDao;

    @Override
    public JSONUtil getAllCrops() {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //获得所有的作物信息
            List<Crop> crops = cropDao.getAllCrop();

            //获取所有的作物信息后返回的json数据
            jsonUtil.setMsg("Get all crops success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(crops);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("CropServiceImpl=>getAllCrops=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Get all crops flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }

    @Override
    public JSONUtil saveCrop(Crop crop) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //保存作物
            cropDao.saveCrop(crop);

            //获取所有的作物信息后返回的json数据
            jsonUtil.setMsg("Save crop success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(crop);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("CropServiceImpl=>saveCrop=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Save crop flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }

    @Override
    public JSONUtil updateCrop(Crop crop) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //获得所有的作物信息
            cropDao.updateCrop(crop);

            //获取所有的作物信息后返回的json数据
            jsonUtil.setMsg("update crop success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(crop);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("CropServiceImpl=>updateCrop=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("update crop flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }

    @Override
    public JSONUtil deleteCrop(String id) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //获得所有的作物信息
            cropDao.deleteCrop(id);

            //获取所有的作物信息后返回的json数据
            jsonUtil.setMsg("delte crop success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(id);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("CropServiceImpl=>deleteCrop=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("delete crop flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }
}
