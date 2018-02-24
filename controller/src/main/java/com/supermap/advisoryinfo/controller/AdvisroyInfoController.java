package com.supermap.advisoryinfo.controller;

import com.supermap.advisoryinfo.entity.Advisoryinfo;
import com.supermap.advisoryinfo.service.AdvisoryinfoService;
import com.supermap.common.JSONUtil;
import com.supermap.mappoint.service.MappointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:langhongshuai
 * @Description:咨询接口层
 * @Date:18/1/29 上午9:27
 */
@Controller
@RequestMapping("AdvisroyInfoController")
public class AdvisroyInfoController {
    /**
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     */
    protected static final Logger logger = LoggerFactory.getLogger(AdvisroyInfoController.class);

    @Autowired
    private AdvisoryinfoService advisoryinfoService;

    /**
     * 通过用户id和区域code获得用户的咨询信息
     */
    @RequestMapping("/getAdvisoryInfoByUIdArea")
    @ResponseBody
    public JSONUtil getAdvisoryInfoByUIdArea(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String areaCode = request.getParameter("areaCode");
        return advisoryinfoService.getAdvisoryInfoByUIdArea(userId,areaCode);
    }

    /**
     * 上传咨询
     */
    @RequestMapping("/addAdvisory")
    @ResponseBody
    public JSONUtil addAdvisory(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String areaCode = request.getParameter("areaCode");
        String question = request.getParameter("question");
        String subjectId = request.getParameter("subjectId");
        String farmlandid = request.getParameter("farmlandId");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");

        Advisoryinfo advisoryinfo = new Advisoryinfo();
        advisoryinfo.setUserId(Integer.parseInt(userId));
        advisoryinfo.setAreacode(areaCode);
        advisoryinfo.setQuestion(question);
        advisoryinfo.setSubjectid(Integer.parseInt(subjectId));
        //无关农田的咨询，不需要上传农田Id
        if(farmlandid!=null) {
            advisoryinfo.setFarmlandid(Integer.parseInt(farmlandid));
        }
        advisoryinfo.setLat(latitude);
        advisoryinfo.setLon(longitude);
        return advisoryinfoService.addAdvisory(advisoryinfo);
    }
}
