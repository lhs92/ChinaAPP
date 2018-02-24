package com.supermap.agriculture.controller;

import com.supermap.advisoryinfo.controller.AdvisroyInfoController;
import com.supermap.advisoryinfo.service.AdvisoryinfoService;
import com.supermap.agrinfo.entity.Agrinfo;
import com.supermap.agrinfo.service.AgrinfoService;
import com.supermap.common.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:langhongshuai
 * @Description:农情接口层
 * @Date:18/1/29 下午2:37
 */
@Controller
@RequestMapping("AgrinfoController")
public class AgrinfoController {
    /**
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(AgrinfoController.class);

    @Autowired
    private AgrinfoService agrinfoService;

    /**
     * 通过用户id和区域code获得用户的农情信息
     */
    @RequestMapping("/getAgrinfoByUIdArea")
    @ResponseBody
    public JSONUtil getAgrinfoByUIdArea(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String areaCode = request.getParameter("areaCode");
        return agrinfoService.getAgrinfoByUIdArea(userId,areaCode);
    }

    /**
     * 添加灾情或农情
     * @param request
     * @return
     */
    @RequestMapping("/addAgrinfoOrDisasterInfo")
    @ResponseBody
    public JSONUtil addAgrinfoOrDisasterInfo(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String farmlandId = request.getParameter("farmlandId");
        String type = request.getParameter("type");
        String breed = request.getParameter("breed");
        String growthPeriod = request.getParameter("growthPeriod");
        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
        String areaCode = request.getParameter("areaCode");
        String descript = request.getParameter("descript");

        Agrinfo agrinfo = new Agrinfo();

        agrinfo.setUserId(Integer.parseInt(userId));
        agrinfo.setFarm(Integer.parseInt(farmlandId));
        agrinfo.setType(Integer.parseInt(type));
        agrinfo.setBreed(Integer.parseInt(breed));
        agrinfo.setGrowthperiod(Integer.parseInt(growthPeriod));
        agrinfo.setLatitude(latitude);
        agrinfo.setLongitude(longitude);
        agrinfo.setAreacode(areaCode);
        agrinfo.setDescript(descript);
        return agrinfoService.addAgrinfoOrDisasterInfo(agrinfo);
    }


}
