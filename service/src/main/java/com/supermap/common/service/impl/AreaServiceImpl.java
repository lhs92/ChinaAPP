package com.supermap.common.service.impl;

import com.supermap.common.dao.AreaDao;
import com.supermap.common.entity.Area;
import com.supermap.common.service.AreaService;
import com.supermap.common.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:区域业务逻辑层
 * @Date:18/1/8 上午11:16
 */
@Service
public class AreaServiceImpl implements AreaService {

    /**
     *使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);

    @Resource
    private AreaDao areaDao;

    @Override
    public JSONUtil getAllAreas() {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //获得所有的区域信息
            List<Area> areas = areaDao.getAllArea();

            //使区域层级化
            areas = organizeArea(areas);

         //获取所有的区域信息后返回的json数据
            jsonUtil.setMsg("Get all areas success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(areas);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("AreaServiceImpl=>getAllArea=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Get all areas flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }

    @Override
    public JSONUtil getAreaByName(String areaName) {
        //初始化Json封装工具类
        JSONUtil jsonUtil = new JSONUtil();
        try {
            //获得区域信息
            Area area = areaDao.getAreaByName(areaName);

            //获取区域信息后返回的json数据
            jsonUtil.setMsg("Get area success！");
            jsonUtil.setIsSuccess(true);
            jsonUtil.setCode(200);
            jsonUtil.setData(area);
        }catch (Exception e) {
            //捕捉数据库异常
            logger.error("AreaServiceImpl=>getAreaByName=>DaoException:"+e.getStackTrace());
            jsonUtil.setMsg("Get area flase！");
            jsonUtil.setIsSuccess(false);
            jsonUtil.setCode(100);
        }
        return jsonUtil;
    }

    /**
     * 将区域层级化
     * @param areaList
     * @return
     */
    private List<Area> organizeArea(List<Area> areaList){
        //创建新的区域列表
        List<Area> areaFirstList = new ArrayList<>();

        for (Area a:areaList) {
            //当区域code的长度为2时，为第一层级
            if(a.getAreaCode().length()==2){
                List<Area> areaSecondList = new ArrayList();
                for (Area b:areaList){
                    //当区域code的长度为4，为第二层级
                    if(b.getAreaCode().length() == 4 && b.getAreaCode().substring(0,2).equals(a.getAreaCode())){
                        List<Area> areaThirdList = new ArrayList();
                        for (Area c:areaList){
                            //当区域code的长度为6，为第三层级
                            if(c.getAreaCode().length() == 6 && c.getAreaCode().substring(0,4).equals(b.getAreaCode())){
                                //增加3级子节点
                                areaThirdList.add(c);
                            }
                        }
                        //设置所有的3级区域子节点
                        b.setChildNode(areaThirdList);
                        //增加2级子节点
                        areaSecondList.add(b);
                    }
                }
                //设置所有的2级区域子节点
                a.setChildNode(areaSecondList);
                //增加1级节点
                areaFirstList.add(a);
            }
        }
        return areaFirstList;
    }


}
