package com.txzhe.service.impl;

import com.txzhe.dao.menu.IMenuDao;
import com.txzhe.entity.menu.MenuDTO;
import com.txzhe.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuDao menuDao;

    public List<MenuDTO> queryAll(Map<String,Object> map) {
        // TODO Auto-generated method stub
        return menuDao.queryAll(map);
    }

}