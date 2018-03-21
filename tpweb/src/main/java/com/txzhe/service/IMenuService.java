package com.txzhe.service;

import com.txzhe.entity.menu.MenuDTO;

import java.util.List;
import java.util.Map;

public interface IMenuService {
    List<MenuDTO> queryAll(Map<String,Object> map);
}
