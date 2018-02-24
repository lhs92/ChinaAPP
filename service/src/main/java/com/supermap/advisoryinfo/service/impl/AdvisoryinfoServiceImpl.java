package com.supermap.advisoryinfo.service.impl;

import com.supermap.advisoryinfo.dao.AdvisoryinfoDao;
import com.supermap.advisoryinfo.entity.Advisoryinfo;
import com.supermap.advisoryinfo.service.AdvisoryinfoService;
import com.supermap.common.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:
 * @Date:18/1/29 上午9:36
 */
@Service
public class AdvisoryinfoServiceImpl implements AdvisoryinfoService {

    /**
     *使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(AdvisoryinfoServiceImpl.class);

    @Resource
    private AdvisoryinfoDao advisoryinfoDao;

    @Override
    public JSONUtil getAdvisoryInfoByUIdArea(String userId,String areaCode) {
            //初始化Json封装工具类
            JSONUtil jsonUtil = new JSONUtil();
            try {
                //获得用户所有的咨询信息
                List<Advisoryinfo> advisoryinfos = advisoryinfoDao.getAdvisoryInfoByUIdArea(userId,areaCode);

                //获得用户所有的咨询信息后返回的json数据
                jsonUtil.setMsg("Get user advisoryinfos success！");
                jsonUtil.setIsSuccess(true);
                jsonUtil.setCode(200);
                jsonUtil.setData(advisoryinfos);
            }catch (Exception e) {
                //捕捉数据库异常
                logger.error("AdvisoryinfoServiceImpl=>getAdvisoryInfoByUserId=>DaoException:"+e.getStackTrace());
                jsonUtil.setMsg("Get user advisoryinfos flase！");
                jsonUtil.setIsSuccess(false);
                jsonUtil.setCode(100);
            }
            return jsonUtil;
        }

    @Override
    public JSONUtil addAdvisory(Advisoryinfo advisoryinfo) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //增加咨询信息
            advisoryinfoDao.addAdvisory(advisoryinfo);
            //增加咨询信息后返回的json数据
            jsonUtil.setMsg("Add advisoryinfo success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(advisoryinfo);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("AdvisoryinfoServiceImpl=>addAdvisory=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Add advisoryinfo flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }
}
