package com.furant.ordersystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.furant.ordersystem.dto.AdminLoginDTO;
import com.furant.ordersystem.entity.AdminDO;
import com.furant.ordersystem.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/login")
    public String login(@RequestBody AdminLoginDTO adminLoginDTO, Model model) {
        Objects.requireNonNull(adminLoginDTO, "AdminLoginDTO不能为空");
        QueryWrapper<AdminDO> wrapper = new QueryWrapper<>();
        wrapper
                .eq("admin_name", adminLoginDTO.getUserName())
                .eq("admin_password", adminLoginDTO.getPassword());
        AdminDO adminDO = adminService.getOne(wrapper);
        log.debug("AdminDO:[{}]", adminDO);
        return "";
    }

}
