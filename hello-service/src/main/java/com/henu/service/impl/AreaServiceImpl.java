package com.henu.service.impl;

import com.henu.dao.AreaDao;
import com.henu.entity.Area;
import com.henu.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public Area queryByAreaId(Integer id) {
        Area area=areaDao.queryAreaById(id);
        return area;
    }

    public AreaServiceImpl() {
        System.out.println("我被初始化了。。。AreaService");
    }
}
