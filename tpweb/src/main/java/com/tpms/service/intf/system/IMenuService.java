package com.tpms.service.intf.system;

import com.tpms.entity.system.MenuDto;
import com.tpms.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMenuService {
    List<MenuDto> queryAll(Map<String, Object> map);

    List<MenuDto> queryMenuList();

    Integer addPrivilege(Integer roleId,Object[] privilegeIds);

    List<User> queryUsers(User user,Map<String,Object> page);

    Integer totalRecords(String tableName);
}
