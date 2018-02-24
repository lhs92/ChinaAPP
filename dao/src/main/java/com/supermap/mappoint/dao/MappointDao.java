package com.supermap.mappoint.dao;

import com.supermap.mappoint.entity.Mappoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:地图点数据访问层
 * @Date:18/1/26 下午5:45
 */
@Mapper
public interface MappointDao {
    /**
     * 获得所有的地图点信息
     * @return
     */
    @Select("select * from t_mappoint")
    public List<Mappoint> getAllMappoint();
}
