package com.henu.dao;


import com.henu.entity.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaDao {
    List <Area> queryArea();
    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
    List<Area> getList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
