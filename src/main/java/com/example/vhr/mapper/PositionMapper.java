package com.example.vhr.mapper;

import com.example.vhr.model.Position;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    @Select("select * from position")
    List<Position> selectAllPosition();

    //    @Delete({"<script> ",
    //        "delete from position where id in ",
    //            "<foreach collection='array' item='item' open='('  separator=',' close=')'>",
    //            "#{item}",
    //            "</foreach>",
    //            "</script>" })
    Integer deleteByIds(Integer[] ids);
}