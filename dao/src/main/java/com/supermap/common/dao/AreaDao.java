package com.supermap.common.dao;

import com.supermap.common.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:区域数据访问层
 * @Date:18/1/8 上午11:34
 */
@Mapper
public interface AreaDao {
    /**
     * 获得所有的区域信息
     * @return
     */
    @Select("select t1.areaid,t1.areaCode,t1.areaName from t_area t1")
    public List<Area> getAllArea();

    /**
     * 通过区域名获取当前区域的信息
     * @param areaName
     * @return
     */
    @Select("select * from t_area where areaname=#{areaName}")
    public Area getAreaByName(@Param("areaName")String areaName);
}
