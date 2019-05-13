package com.accp.dao;

import com.accp.domain.Plate;
import com.accp.domain.PlateExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

public interface PlateMapper {
    int countByExample(PlateExample example);

    int deleteByExample(PlateExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Plate record);

    int insertSelective(Plate record);

    List<Plate> selectByExample(PlateExample example);

    Plate selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Plate record, @Param("example") PlateExample example);

    int updateByExample(@Param("record") Plate record, @Param("example") PlateExample example);

    int updateByPrimaryKeySelective(Plate record);

    int updateByPrimaryKey(Plate record);
    
    List<Plate> queryAll(@Param("name")String name);
    
    int deleteAll(Integer[] pid);
    
    List<Plate> queryPlate(@Param("rid") Integer rid);
    
    @MapKey("url")
	public Map<String, Plate> queryPlateByUserId(@Param("uid") Integer uid);
    
    public List<Plate> queryLeftNav(@Param("uid") Integer uid);
    
    public List<Plate> queryRolePlate(@Param("rid") Integer rid);
    
    public List<Plate> queryPlateAll();
}