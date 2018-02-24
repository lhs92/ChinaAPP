package com.supermap.common.controller;

import com.supermap.common.JSONUtil;
import com.supermap.common.entity.Crop;
import com.supermap.common.service.CropService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:langhongshuai
 * @Description:作物接口层
 * @Date:18/1/8 上午11:26
 */
@Controller
@RequestMapping("CropController")
public class CropController {
    /**
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(CropController.class);

    @Autowired
    private CropService cropService;

    /**
     * 角色获取
     */
    @RequestMapping("/getAllCrops")
    @ResponseBody
    public JSONUtil getAllAreas(){
        return cropService.getAllCrops();
    }

    /**
     * 保存作物
     */
    @RequestMapping("/saveCrop")
    @ResponseBody
    public JSONUtil saveCrop(){
        Crop crop = new Crop();
        return cropService.saveCrop(crop);
    }

    /**
     * 更新作物
     */
    @RequestMapping("updateCrop")
    @ResponseBody
    public JSONUtil updateCrop(){
        Crop crop = new Crop();
        return cropService.updateCrop(crop);
    }

    /**
     * 删除作物
     */
    @RequestMapping("deleteCrop")
    @ResponseBody
    public JSONUtil delteCrop(HttpServletRequest request){
        String id = request.getParameter("id");
        return cropService.deleteCrop(id);
    }
}
