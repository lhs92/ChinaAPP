package com.supermap.advisoryinfo.dao;

import com.supermap.advisoryinfo.entity.Advisoryinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:咨询数据访问层
 * @Date:18/1/28 下午11:57
 */
@Mapper
public interface AdvisoryinfoDao {
    /**
     * 获得用户的咨询信息
     * @return
     */
    @Select("select * from t_advisoryinfo where userId=#{userId} and IF(ISNULL(#{areaCode}),true,t1.areacode=#{areaCode})")
    public List<Advisoryinfo> getAdvisoryInfoByUIdArea(@Param("userId")String userId,@Param("areaCode")String areaCode);

    /**
     *  增加咨询
     * @param advisoryinfo
     */
    @Insert("Insert into t_advisoryinfo(userId,areacode,question,subjectid,farmlandid,lat,lon) \n" +
            "values(#{Advisory.userId},#{Advisory.areacode},#{Advisory.question}\n" +
            ",#{Advisory.subjectid},#{Advisory.farmlandid},#{Advisory.lat},#{Advisory.lon})")
    public void addAdvisory(@Param("Advisory")Advisoryinfo advisoryinfo);
}
