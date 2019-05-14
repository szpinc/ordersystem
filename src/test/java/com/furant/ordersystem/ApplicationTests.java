package com.furant.ordersystem;

import com.furant.ordersystem.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

    @Autowired
    private AdminService adminService;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testAdminService() {
        adminService.list().forEach(adminDO -> log.info("Admin[{}]", adminDO));
    }

}
