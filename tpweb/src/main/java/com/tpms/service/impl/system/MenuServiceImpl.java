package com.tpms.service.impl.system;

import com.tpms.dao.system.IMenuDao;
import com.tpms.entity.system.MenuDto;
import com.tpms.service.intf.system.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuDao menuDao;

    public List<MenuDto> queryAll(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return menuDao.queryAll(map);
    }

}
