package com.accp.dao;

import com.accp.domain.Dynamicpicture;
import com.accp.domain.DynamicpictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicpictureMapper {
    int countByExample(DynamicpictureExample example);

    int deleteByExample(DynamicpictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dynamicpicture record);

    int insertSelective(Dynamicpicture record);

    List<Dynamicpicture> selectByExample(DynamicpictureExample example);

    Dynamicpicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dynamicpicture record, @Param("example") DynamicpictureExample example);

    int updateByExample(@Param("record") Dynamicpicture record, @Param("example") DynamicpictureExample example);

    int updateByPrimaryKeySelective(Dynamicpicture record);

    int updateByPrimaryKey(Dynamicpicture record);
    
    List<Dynamicpicture> imgselect(Integer id);
}