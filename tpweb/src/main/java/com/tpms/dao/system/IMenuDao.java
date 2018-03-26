package com.tpms.dao.system;

import com.tpms.entity.system.MenuDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMenuDao {
    List<MenuDto> queryAll(@Param("q") Map<String,Object> queryMap);

    List<MenuDto> queryMenuList();
}
