package com.accp.qyj.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Order;
import com.accp.domain.Orderdetail;
import com.accp.domain.OrderdetailExample;

public interface OrderdetailService {
    int countByExample(OrderdetailExample example);

    int deleteByExample(OrderdetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailExample example);

    Orderdetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
    
    //每个订单时间大致
    Orderdetail queryTime(Integer oid);
    
    //查看此订单此场地这个时间是否可以执行
    Orderdetail queryByFid(Orderdetail od);
    
    Orderdetail queryTime1(Orderdetail od);
    
    Orderdetail queryByFid1(Orderdetail od);
    
    Integer[] qeuryid(Order oid);
    
    List<Orderdetail> queryByOid(Integer oid);
}
