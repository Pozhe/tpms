package com.tpms.controller.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tpms.entity.system.MenuDto;
import com.tpms.entity.user.User;
import com.tpms.service.intf.system.IMenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/sys")
public class SysManageController {

    @Autowired
    private IMenuService menuService;


    @RequestMapping(value = "/addPrivilege",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@Param("param") String param){
        //{"privilegeIds":["1","2","8"],"roleId":2}
        JSONObject paramObj = JSONObject.parseObject(param);
        JSONArray privilegeIds = paramObj.getJSONArray("privilegeIds");
        Integer isAddSucc = menuService.addPrivilege(paramObj.getInteger("roleId"), privilegeIds.toArray());
        Map<String,Object> map = new HashMap<>();
        if(isAddSucc > 0){
            map.put("code","200");
            map.put("message","success");
        }else{
            map.put("code","-1");
            map.put("message","添加失败");
        }
        return map;
    }
}
