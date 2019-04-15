package com.accp.qyj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.accp.domain.Plate;
import com.accp.domain.PlateExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface PlateService {
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
    
    List<Plate> queryAll(String name);
    
    int deleteAll(Integer[] pid);
    
    public PageInfo<Plate> queryByPage(Integer currentPage , Integer pageSize , String name);
    
    List<Plate> queryPlate(@Param("rid") Integer rid);
}
