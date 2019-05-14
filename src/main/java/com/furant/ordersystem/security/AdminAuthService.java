package com.furant.ordersystem.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.furant.ordersystem.entity.AdminDO;
import com.furant.ordersystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Service
public class AdminAuthService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        AdminDO adminDO = adminService.getBaseMapper().selectOne(new QueryWrapper<AdminDO>().eq("admin_name", userName));

        assert adminDO != null;
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ADMIN");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(simpleGrantedAuthority);
        return new User(adminDO.getAdminName(), adminDO.getAdminPassword(), grantedAuthorities);
    }
}
