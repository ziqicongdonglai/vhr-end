package com.example.vhr.mapper;

import com.example.vhr.model.Position;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/25 19:58
 * @description
 */
@SpringBootTest
@Slf4j
class PositionMapperTest {
    @Resource
    private PositionMapper positionMapper;

    @Test
    public void testSelectAllPosition() {
        List<Position> positions = positionMapper.selectAllPosition();
        log.info(positions.toString());
    }
}