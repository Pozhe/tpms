package com.tpms.service.intf.system;

import com.tpms.entity.system.MenuDTO;

import java.util.List;
import java.util.Map;

public interface IMenuService {
    List<MenuDTO> queryAll(Map<String,Object> map);
}
