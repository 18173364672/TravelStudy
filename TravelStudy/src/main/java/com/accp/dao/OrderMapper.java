package com.accp.dao;

import com.accp.domain.MonthOrder;
import com.accp.domain.MonthSr;
import com.accp.domain.Order;
import com.accp.domain.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<MonthSr> SelectMonthSr(String years);
    
    List<MonthOrder> SelectMonthOr(String years);
    
    List<MonthOrder> SelectOrYears();
    
    List<Order> queryAll(@Param ("name") String name);
}