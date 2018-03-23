package com.tpms.controller.system;

import com.tpms.entity.system.MenuDto;
import com.tpms.service.intf.system.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private IMenuService menuService;

    /**
     * 获取菜单JSON
     * @return json数据
     */
    @RequestMapping(value = "/menu")
    @ResponseBody
    public Object listMenu() {

        // 获取cookie中登录名称，判断是否登录
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "111");
        List<MenuDto> dtoList = menuService.queryAll(map);
        List<MenuDto> menuDtos = treeMenuList(dtoList, 0);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",menuDtos);
        resultMap.put("basePath","/tpms");
        return resultMap;
    }

    /**
     * 构建菜单列表对象
     * @param menuList db中查询出来的集合
     * @param parentId 父ID
     * @return
     */
    public List<MenuDto> treeMenuList(List<MenuDto> menuList, int parentId) {
        List<MenuDto> tmpList = new ArrayList<>();
        for (MenuDto dto : menuList) {
            if (dto.getParent() == parentId) {
                tmpList.add(dto);
                dto.setSubmenu(treeMenuList(menuList, Integer.parseInt(dto.getId())));
            }
        }
        return tmpList;
    }

    @RequestMapping(value = "/main")
    public ModelAndView toIndex() {
        return new ModelAndView("index");
    }
}
