package com.supermap.advisoryinfo.service;

import com.supermap.advisoryinfo.entity.Advisoryinfo;
import com.supermap.common.JSONUtil;

/**
 * @Author:langhongshuai
 * @Description:
 * @Date:18/1/29 上午9:36
 */
public interface AdvisoryinfoService {

    /**
     * 获得咨询信息
     * @return
     */
    public JSONUtil getAdvisoryInfoByUIdArea(String userId,String areaCode);

    /**
     * 上传咨询
     */
    public JSONUtil addAdvisory(Advisoryinfo advisoryinfo);
}
