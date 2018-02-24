package com.supermap.agrinfo.dao;

import com.supermap.agrinfo.entity.Agrinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:农情数据访问层
 * @Date:18/1/29 下午2:42
 */
@Mapper
public interface AgrinfoDao {
    /**
     * 获得用户的所有农情信息
     * @return
     */
    @Select("select * from t_agrinfo where userId=#{userId} and IF(ISNULL(#{areaCode}),true,areacode=#{areaCode})")
    public List<Agrinfo> getAgrinfoByUIdArea(@Param("userId")String userId,@Param("areaCode")String areaCode);

    /**
     *增加农情和灾情
     * @param agrinfo
     */
    @Insert("insert into t_agrinfo(userId,farm,type,breed,growthperiod,longitude,latitude,areacode,descript)\n " +
            "values(#{agrinfo.userId},#{agrinfo.farm},#{agrinfo.type},#{agrinfo.breed},#{agrinfo.growthperiod},\n" +
            "#{agrinfo.longitude},#{agrinfo.latitude},#{agrinfo.areacode},#{agrinfo.descript})")
    public void addAgrinfoOrDisasterInfo(@Param("agrinfo")Agrinfo agrinfo);
}
