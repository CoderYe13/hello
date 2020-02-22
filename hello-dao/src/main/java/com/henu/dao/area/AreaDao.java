package com.henu.dao.area;


import com.henu.entity.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AreaDao {
    List <Area> queryArea();
    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
    List<Area> getList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
