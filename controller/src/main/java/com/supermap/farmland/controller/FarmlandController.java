package com.supermap.farmland.controller;

import com.sun.jndi.ldap.ext.StartTlsResponseImpl;
import com.supermap.advisoryinfo.service.AdvisoryinfoService;
import com.supermap.common.JSONUtil;
import com.supermap.farmland.entity.Farmland;
import com.supermap.farmland.service.FarmlandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:langhongshuai
 * @Description:农田接口层
 * @Date:18/1/29 上午9:26
 */
@Controller
@RequestMapping("FarmlandController")
public class FarmlandController {
    /**
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(FarmlandController.class);

    @Autowired
    private FarmlandService farmlandService;

    /**
     * 通过用户id和区域code获得用户的农田信息
     */
    @RequestMapping("/getFarmlandByUIdArea")
    @ResponseBody
    public JSONUtil getFarmlandByUIdArea(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String areaCode = request.getParameter("areaCode");
        return farmlandService.getFarmlandByUIdArea(userId,areaCode);
    }

    /**
     * 增加农田
     * @param request
     * @return
     */
    @RequestMapping("/addFarmland")
    @ResponseBody
    public JSONUtil addFarmland(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String flLongitude = request.getParameter("longitude");
        String flLatitude = request.getParameter("latitude");
        String flheight = request.getParameter("height");
        String flAreaCode = request.getParameter("areaCode");
        String flArea = request.getParameter("area");
        String flCoordinates = request.getParameter("coordinates");
        String flDescript = request.getParameter("descript");
        String crop = request.getParameter("crop");
        Farmland farmland = new Farmland();
        farmland.setUserId(Integer.parseInt(userId));
        farmland.setLatitude(Double.parseDouble(flLatitude));
        farmland.setLongitude(Double.parseDouble(flLongitude));
        farmland.setHeight(Integer.parseInt(flheight));
        farmland.setCode(flAreaCode);
        farmland.setArea(Double.parseDouble(flArea));
        farmland.setCoordinates(flCoordinates);
        farmland.setDescript(flDescript);
        farmland.setCrop(Integer.parseInt(crop));
        return farmlandService.addFarmland(farmland);
    }
}
