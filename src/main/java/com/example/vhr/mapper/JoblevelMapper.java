package com.example.vhr.mapper;

import com.example.vhr.model.Joblevel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JoblevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);

    @Select("select * from joblevel")
    List<Joblevel> selectAllJobLevel();

    Integer deleteByIds(Integer[] ids);
}