package com.accp.dao;

import com.accp.domain.BasePay;
import com.accp.domain.BasePayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasePayMapper {
    int countByExample(BasePayExample example);

    int deleteByExample(BasePayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BasePay record);

    int insertSelective(BasePay record);

    List<BasePay> selectByExample(BasePayExample example);

    BasePay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BasePay record, @Param("example") BasePayExample example);

    int updateByExample(@Param("record") BasePay record, @Param("example") BasePayExample example);

    int updateByPrimaryKeySelective(BasePay record);

    int updateByPrimaryKey(BasePay record);
}