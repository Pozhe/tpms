package com.tpms.controller.system;

import com.tpms.entity.system.MenuDTO;
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

    @RequestMapping(value = "/menu")
    @ResponseBody
    public Object listMenu(){

        //获取cookie中登录名称，判断是否登录
        Map<String, Object> map = new HashMap<>();
        map.put("userName","111");
        List<MenuDTO> dtoList = menuService.queryAll(map);
        List<MenuDTO> menuDTOS = treeMenuList(dtoList, 0);
        return menuDTOS;
    }

    public List<MenuDTO> treeMenuList(List<MenuDTO> menuList, int parentId) {
        List<MenuDTO> tmpList = new ArrayList<>();
        for (MenuDTO dto:menuList) {
            if(dto.getParent() == parentId){
                tmpList.add(dto);
                dto.setSubmenu(treeMenuList(menuList,Integer.parseInt(dto.getId())));
            }
        }
        return tmpList;
    }

    @RequestMapping(value = "/main")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }
}
