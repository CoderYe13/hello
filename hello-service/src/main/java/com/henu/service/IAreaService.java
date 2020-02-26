package com.henu.service;


import com.henu.entity.Area;

import java.util.Map;

public interface IAreaService {
    Area queryByAreaId(Integer id);

    Map<Integer,Area> queryAreaByMap();
}
