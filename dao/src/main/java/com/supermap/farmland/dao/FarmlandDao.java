package com.supermap.farmland.dao;

import com.supermap.farmland.entity.Farmland;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:农田数据访问层
 * @Date:18/1/28 下午10:52
 */
@Mapper
public interface FarmlandDao {
    /**
     * 获得用户的所有农田信息
     * @return
     */
    @Select("select t1.*,t4.name,t4.crop from t_farmland t1 \n" +
            "inner JOIN\n" +
            "(select t2.*,t3.name from t_farmcrops t2 left JOIN t_cropstype t3 on t2.crop=t3.id) t4\n" +
            "on t1.id=t4.farmland where t1.userId=#{userId} and IF(ISNULL(#{areaCode}),true,t1.code=#{areaCode})")
    public List<Farmland> getFarmlandByUIdArea(@Param("userId")String userId,@Param("areaCode") String areaCode);

    /**
     * 增加农田
     * @param farmland
     */
    @Insert("Insert into t_farmland(userId,coordinates,descript,height,longitude,latitude,area,code)\n " +
            "values(#{farmland.userId},#{farmland.coordinates},#{farmland.descript},\n" +
            "#{farmland.height},#{farmland.longitude},#{farmland.latitude},#{farmland.area},#{farmland.code}\n" +
            ")")
    public void addFarmland(@Param("farmland")Farmland farmland);

    /**
     * 增加农田作物关联
     * @param crop
     * @param farmland
     */
    @Insert("Insert into t_farmcrops(crop,farmland) values(#{crop},#{farmland})")
    public void addFarmCrops(@Param("farmland")int farmland,@Param("crop")int crop);

    /**
     * 获取刚刚插入的id
     */
    @Select("Select max(id) from t_farmland")
    public int getFarmId();
}
