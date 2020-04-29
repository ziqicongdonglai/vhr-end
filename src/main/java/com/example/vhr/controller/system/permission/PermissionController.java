package com.example.vhr.controller.system.permission;

import com.example.vhr.model.Menu;
import com.example.vhr.model.RespBean;
import com.example.vhr.model.Role;
import com.example.vhr.service.MenuService;
import com.example.vhr.service.system.permission.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/29 9:11
 * @description
 */
@RestController
@RequestMapping("/system/basic/permiss")
@Api(tags = {"权限组 API"}, produces = "http")
@SwaggerDefinition(tags = {
        @Tag(name = "权限组 API", description = "权限组管理的API接口")
})
public class PermissionController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    @ApiOperation(value = "获取所有角色",
            notes = "所有角色的信息列表",
            produces = "application/json, application/xml")
    public RespBean getAllRole() {
        List<Role> roles = roleService.getAllRoles();
        return RespBean.ok("获取成功", roles);
    }

    @GetMapping("/menus")
    @ApiOperation(value = "获取所有三级菜单",
            notes = "所有三级菜单的列表")
    public RespBean getAllMenus() {
        List<Menu> menus = roleService.getAllMenus();
        return RespBean.ok("获取成功", menus);
    }

    @GetMapping("/mid/{rid}")
    @ApiOperation(value = "获取角色对应的菜单id集合", notes = "角色对应的菜单id列表")
    public RespBean getMidsByRid(@PathVariable Integer rid) {
        List<Integer> rids = menuService.getMidsByRid(rid);
        return RespBean.ok("获取成功", rids);
    }

    @PutMapping("/")
    @ApiOperation(value = "修改角色对应的菜单")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
}
