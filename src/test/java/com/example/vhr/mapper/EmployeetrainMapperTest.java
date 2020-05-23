package com.example.vhr.mapper;

import com.example.vhr.model.Employeetrain;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ke_zhang
 * @create 2020/5/23 23:26
 * @description
 */
@SpringBootTest
@Slf4j
class EmployeetrainMapperTest {
    @Resource
    EmployeetrainMapper employeetrainMapper;

    @Test
    public void testSelectByPrimaryKey() {
        Employeetrain employeetrain = employeetrainMapper.selectByPrimaryKey(1);
        log.info(employeetrain.toString());
    }
}