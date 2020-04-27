package com.example.vhr.controller.config;

import com.example.vhr.model.Menu;
import com.example.vhr.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/21 23:50
 * @description
 */
@RestController
@Api(tags = {"菜单 API"}, produces = "http")
@SwaggerDefinition(tags = {
        @Tag(name = "菜单 API", description = "菜单管理的API接口")
})
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;
    @GetMapping("/menu")
    @ApiOperation(value = "菜单列表",
            notes = "完整的菜单内容列表",
            produces = "application/json, application/xml")
    public List<Menu> getMenusByHrId() {
        List<Menu> menus = menuService.getMenusByHrId();
        return menus;
    }
}
