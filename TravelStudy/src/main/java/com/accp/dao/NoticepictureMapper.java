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
}