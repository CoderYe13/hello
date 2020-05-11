package com.henu.service;


import com.github.pagehelper.PageInfo;
import com.henu.entity.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IAreaService {
    Area queryByAreaId(Integer id);

    Map<Integer,Area> queryAreaByMap();

    //批量插入数据
    int bunchInsertArea( List<Area> area);

    PageInfo<Area> getAreaList(int pageNum,int pageSize);
}
