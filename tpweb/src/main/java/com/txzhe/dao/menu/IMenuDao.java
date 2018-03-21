package com.txzhe.dao.menu;

import com.txzhe.entity.menu.MenuDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMenuDao {
    List<MenuDTO> queryAll(@Param("q") Map<String,Object> queryMap);
}
