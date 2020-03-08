package com.henu.dao.area;


import com.henu.entity.Area;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AreaDao {
    List <Area> queryArea();
    //查询多个元素，用一个map封装返回,此时要注明返回值map的key
    @MapKey("areaId")
    Map<Integer,Area> queryAreaMap();
    //通过List批量插入Area
    int batchInsertArea(@Param("areas")List<Area> areas);

    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
    List<Area> getList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
