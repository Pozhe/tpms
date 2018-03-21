package com.tpms.dao.system;

import com.tpms.entity.system.MenuDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMenuDao {
    List<MenuDTO> queryAll(@Param("q") Map<String,Object> queryMap);
}
