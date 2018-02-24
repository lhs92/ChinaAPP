package com.supermap.mappoint.service.impl;

import com.supermap.common.JSONUtil;
import com.supermap.mappoint.dao.MappointDao;
import com.supermap.mappoint.entity.Mappoint;
import com.supermap.mappoint.service.MappointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:地图点位业务逻辑层
 * @Date:18/1/26 下午5:35
 */
@Service
public class MappointServiceImpl implements MappointService{


    /**
     *使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(MappointServiceImpl.class);

    @Resource
    private MappointDao mappointDao;

    @Override
    public JSONUtil getAllMappoints() {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //获得所有的地图点信息
            List<Mappoint> mappoints = mappointDao.getAllMappoint();

            //获得所有的地图点信息后返回的json数据
            jsonUtil.setMsg("Get all mappoints success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(mappoints);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("MappointServiceImpl=>getAllMappoints=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Get all mappoints flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }
}
