package com.supermap.mappoint.controller;


import com.supermap.common.JSONUtil;
import com.supermap.mappoint.service.MappointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:langhongshuai
 * @Description:地图点接口层
 * @Date:18/1/8 上午11:26
 */
@Controller
@RequestMapping("MappiontController")
public class MappiontController {
    /**
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(com.supermap.mappoint.controller.MappiontController.class);

    @Autowired
    private MappointService mappointService;

    /**
     * 地图点获取
     */
    @RequestMapping("/getAllMappoint")
    @ResponseBody
    public JSONUtil getAllMappoint(){return mappointService.getAllMappoints();}
}