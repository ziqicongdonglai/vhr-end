package com.example.vhr.service.system.permission;

import com.example.vhr.mapper.RoleMapper;
import com.example.vhr.model.Menu;
import com.example.vhr.model.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/29 9:10
 * @description
 */
@Service
public class RoleService {
    @Resource
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public List<Menu> getAllMenus() {
        return roleMapper.getAllMenus();
    }
}
