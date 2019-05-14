package com.furant.ordersystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furant.ordersystem.entity.AdminDO;
import com.furant.ordersystem.mapper.AdminMapper;
import com.furant.ordersystem.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminDO> implements AdminService {
}
