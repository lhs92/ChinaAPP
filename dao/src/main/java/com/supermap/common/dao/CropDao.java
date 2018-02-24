package com.supermap.common.dao;

import com.supermap.common.entity.Crop;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author:langhongshuai
 * @Description:作物数据访问层
 * @Date:18/1/8 上午11:36
 */
@Mapper
public interface CropDao {

    /**
     * 获得所有的作物信息
     * @return
     */
    @Select("select * from t_crop")
    public List<Crop> getAllCrop();

    @Insert("insert t_crop(id,sys_org_code,sys_company_code,code,name,description,levels,root_code,parentid,sequence,create_date) values("
            + "#{Crop.id},#{Crop.sys_org_code},#{Crop.sys_company_code},#{Crop.code},#{Crop.name},"
            + "#{Crop.description},#{Crop.levels},#{Crop.root_code},#{Crop.parentid},#{Crop.sequence},#{Crop.create_date})")
    public void saveCrop(@Param("Crop") Crop crop);

    @Update("update t_crop t1 set t1.sys_org_code=#{Crop.sys_org_code},set t1.sys_company_code=#{Crop.sys_company_code},set t1.code=#{Crop.code},"
            + "set t1.name =#{Crop.name},set t1.description=#{Crop.description},set t1.levels=#{Crop.levels},set t1.root_code=#{Crop.root_code}"
            + "set t1.parentid=#{Crop.parantid},set t1.sequence=#{Crop.sequence},set t1.create_date=#{Crop.create_date} where t1.id=#{Crop.id}")
    public void updateCrop(Crop crop);

    @Delete("delete from t_crop where id=#{id} ")
    public void deleteCrop(@Param("id") String id);

}
