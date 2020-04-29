package com.example.vhr.service;

import com.example.vhr.mapper.MenuMapper;
import com.example.vhr.mapper.MenuRoleMapper;
import com.example.vhr.model.Hr;
import com.example.vhr.model.Menu;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/21 23:43
 * @description
 */
@Service
public class MenuService {
    @Resource
    MenuMapper menuMapper;
    @Resource
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());

    }

    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Integer> getMidsByRid(Integer id) {
        return menuMapper.getMidsByRid(id);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        int num = menuRoleMapper.insertRecord(rid, mids);
        return num == mids.length;
    }

}