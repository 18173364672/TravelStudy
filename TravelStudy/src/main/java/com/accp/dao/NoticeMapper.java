package com.accp.dao;

import com.accp.domain.Notice;
import com.accp.domain.NoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
    int countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    
    /**
     * 新增公告表
     * @param notice
     * @return
     */
    int add(String title,String content,Integer uid);
    
    /**
     * 查询最后的数据
     * @return
     */
    Notice selectOrderBy();
    
    /**
     * 按员工发送信息
     * @param title
     * @param content
     * @param uid
     * @param spare1
     * @return
     */
    int toAdd(String title,String content,Integer uid,String spare1);
    
    
    /**
     * 分页带条件查询
     * @param employeename
     * @return
     */
    List<Notice> selecQueryFeYue(String title);
    
    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Notice selectById(Integer id);
    
    
    /**
     * 查询最后一条数据
     * @param id
     * @return
     */
    Notice queryAll();
    
}