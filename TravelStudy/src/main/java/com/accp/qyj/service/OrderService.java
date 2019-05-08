package com.accp.qyj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Order;
import com.accp.domain.OrderExample;
import com.accp.domain.ResultMapOrderDetail;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface OrderService {
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
    
    List<Order> queryAll(String name);
    
    PageInfo<Order> queryByPage(String name , Integer currentPage , Integer pageSize);
    
    List<ResultMapOrderDetail> queryOrderDetail(Integer oid);
    
	int deleteOrderDetail(Integer id);
}
