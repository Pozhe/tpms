package com.tpms.service.impl.system;

import com.tpms.dao.system.IMenuDao;
import com.tpms.entity.system.MenuDto;
import com.tpms.entity.user.User;
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
        return menuDao.queryAll(map);
    }

    @Override
    public List<MenuDto> queryMenuList() {
        return menuDao.queryMenuList();
    }

    @Override
    public Integer addPrivilege(Integer roleId, Object[] privilegeIds) {
        return menuDao.addPrivilege(roleId,privilegeIds);
    }

    @Override
    public List<User> queryUsers(User user,Map<String,Object> page) {
        return menuDao.listUser(user,page);
    }

    @Override
    public Integer totalRecords(String tableName) {
        return menuDao.totalRecords(tableName);
    }

}
