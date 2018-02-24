package com.supermap.agrinfo.service.impl;

import com.supermap.agrinfo.dao.AgrinfoDao;
import com.supermap.agrinfo.entity.Agrinfo;
import com.supermap.agrinfo.service.AgrinfoService;
import com.supermap.common.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:农情业务逻辑层
 * @Date:18/1/29 下午3:01
 */
@Service
public class AgrinfoServiceImpl implements AgrinfoService {
    /**
     *使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(AgrinfoServiceImpl.class);

    @Resource
    private AgrinfoDao agrinfoDao;

    @Override
    public JSONUtil getAgrinfoByUIdArea(String userId,String areaCode) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //获得用户所有的农情信息
            List<Agrinfo> agrinfos = agrinfoDao.getAgrinfoByUIdArea(userId,areaCode);

            //获得用户所有的农情信息后返回的json数据
            jsonUtil.setMsg("Get user agrinfos success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(agrinfos);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("AgrinfoServiceImpl=>getAgrinfoByUserId=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Get user agrinfos flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }

    @Override
    public JSONUtil addAgrinfoOrDisasterInfo(Agrinfo agrinfo) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //获得用户所有的农情信息
           agrinfoDao.addAgrinfoOrDisasterInfo(agrinfo);

            //获得用户所有的农情信息后返回的json数据
            jsonUtil.setMsg("add user agrinfos or disaster success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(agrinfo);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("AgrinfoServiceImpl=>addAgrinfoOrDisasterInfo=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("add user agrinfos or disaster flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }
}
