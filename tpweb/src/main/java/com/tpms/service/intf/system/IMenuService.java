package com.tpms.service.intf.system;

import com.tpms.entity.system.MenuDto;

import java.util.List;
import java.util.Map;

public interface IMenuService {
    List<MenuDto> queryAll(Map<String, Object> map);

    List<MenuDto> queryMenuList();
}
