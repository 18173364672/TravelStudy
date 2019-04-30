package com.accp.dao;

import com.accp.domain.Noticepicture;
import com.accp.domain.NoticepictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticepictureMapper {
    int countByExample(NoticepictureExample example);

    int deleteByExample(NoticepictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Noticepicture record);

    int insertSelective(Noticepicture record);

    List<Noticepicture> selectByExample(NoticepictureExample example);

    Noticepicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Noticepicture record, @Param("example") NoticepictureExample example);

    int updateByExample(@Param("record") Noticepicture record, @Param("example") NoticepictureExample example);

    int updateByPrimaryKeySelective(Noticepicture record);

    int updateByPrimaryKey(Noticepicture record);
    
    /**
     * 添加一张新图片
     * @param url
     * @return
     */
    int addinsert(String url);
    
    /**
     * 查询最后一张图片
     * @return
     */
    Noticepicture selectOrderBy();
    
    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Noticepicture selectById(Integer id);
    
}