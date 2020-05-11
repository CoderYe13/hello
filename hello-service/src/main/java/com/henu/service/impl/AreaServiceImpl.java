package com.henu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henu.dao.area.AreaDao;
import com.henu.entity.Area;
import com.henu.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public Area queryByAreaId(Integer id) {
        Area area=areaDao.queryAreaById(id);
        return area;
    }

    @Override
    public Map<Integer, Area> queryAreaByMap() {
        Map<Integer,Area> areaMap=areaDao.queryAreaMap();
        return areaMap;
    }

    @Override
    public int bunchInsertArea(List<Area> areas) {
        int row=areaDao.batchInsertArea(areas);
        return row;
    }

    @Override
    public PageInfo<Area> getAreaList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Area> areas=areaDao.getList();
        PageInfo<Area> pageInfo=new PageInfo<>(areas);
        return pageInfo;
    }

    public AreaServiceImpl() {
        System.out.println("我被初始化了。。。AreaService");
    }
}
