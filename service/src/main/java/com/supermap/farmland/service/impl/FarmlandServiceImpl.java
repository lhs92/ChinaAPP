package com.supermap.farmland.service.impl;

import com.supermap.common.JSONUtil;
import com.supermap.farmland.dao.FarmlandDao;
import com.supermap.farmland.entity.Farmland;
import com.supermap.farmland.service.FarmlandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:
 * @Date:18/1/29 上午9:35
 */
@Service
public class FarmlandServiceImpl implements FarmlandService {
    /**
     *使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(FarmlandServiceImpl.class);

    @Resource
    private FarmlandDao farmlandDao;

    @Override
    public JSONUtil getFarmlandByUIdArea(String userId,String areaCode) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //获得用户所有的农田信息
            List<Farmland> farmlands = farmlandDao.getFarmlandByUIdArea(userId,areaCode);

            //获得用户所有的农田信息后返回的json数据
            jsonUtil.setMsg("Get user farmlands success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(farmlands);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("FarmlandServiceImpl=>getFarmlandByUserId=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Get user farmlands flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }

    @Override
    public JSONUtil addFarmland(Farmland farmland) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            // 增加农田信息
            farmlandDao.addFarmland(farmland);
            //获得才增加的农田信息
            farmland.setId(farmlandDao.getFarmId());
            //增加农田作物信息关联表
            farmlandDao.addFarmCrops(farmland.getId(),farmland.getCrop());
            //增加农田信息后返回的json数据
            jsonUtil.setMsg("Add farmland success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(farmland);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("FarmlandServiceImpl=>addFarmland=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Add farmland flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }
}