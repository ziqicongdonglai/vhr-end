package com.example.vhr.service;

import com.example.vhr.mapper.HrMapper;
import com.example.vhr.model.Hr;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ke_zhang
 * @create 2020/4/20 9:06
 * @description
 */
@Service
public class HrService implements UserDetailsService {
    @Resource
    private HrMapper hrMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
}
