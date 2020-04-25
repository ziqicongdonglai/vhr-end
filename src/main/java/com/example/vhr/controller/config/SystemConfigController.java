package com.example.vhr.controller.config;

import com.example.vhr.model.Menu;
import com.example.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/21 23:50
 * @description
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;
    @RequestMapping("/menu")
    public List<Menu> getMenusByHrId() {
        List<Menu> menus = menuService.getMenusByHrId();
        return menus;
    }
}
