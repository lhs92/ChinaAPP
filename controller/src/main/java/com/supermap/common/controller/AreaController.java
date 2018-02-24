package com.supermap.common.controller;

import com.supermap.common.service.AreaService;
import com.supermap.common.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:langhongshuai
 * @Description:区域接口层
 * @Date:18/1/8 上午11:25
 */
@Controller
@RequestMapping("AreaController")
public class AreaController {
    /**
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    /**
     * 区域获取
     */
    @RequestMapping("/getAllAreas")
    @ResponseBody
    public JSONUtil getAllAreas(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        return areaService.getAllAreas();
    }

    /**
     * 通过区域名获取区域code
     */
    @RequestMapping("getAreaByName")
    @ResponseBody
    public JSONUtil getAreaCodeByName(HttpServletRequest request){
        String areaName = request.getParameter("areaName");
        return areaService.getAreaByName(areaName);
    }
}
