package com.tpms.dao.system;

import com.tpms.entity.system.MenuDto;
import com.tpms.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMenuDao {
    List<MenuDto> queryAll(@Param("q") Map<String,Object> queryMap);

    List<MenuDto> queryMenuList();

    Integer addPrivilege(@Param("roleId") Integer roleId, @Param("privilegeIds") Object[] privilegeIds);

    List<User> listUser(@Param("dto") User user,@Param("pc") Map<String,Object> page);

    Integer totalRecords(@Param("tableName") String tableName);
}
