package com.example.vhr.service.per;

import com.example.vhr.mapper.EmployeetrainMapper;
import com.example.vhr.model.Employeetrain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/5/24 0:09
 * @description
 */
@Service
public class EmployeetrainService {
    @Resource
    EmployeetrainMapper employeetrainMapper;

    public List<Employeetrain> getAllEmployeetrains() {
        return employeetrainMapper.selectAllEmployeetrains();
    }

    public Integer addEmployeetrain(Employeetrain employeetrain) {
        employeetrain.setEid(1);
        employeetrain.setRemark("");
        employeetrain.setTrainDate(new Date());
        return employeetrainMapper.insertSelective(employeetrain);
    }

    public Integer updateEmployeetrain(Employeetrain employeetrain) {
        return employeetrainMapper.updateByPrimaryKeySelective(employeetrain);
    }

    public Integer deleteEmployeetrain(Integer id) {
        return employeetrainMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteEmployeetrain(Integer[] ids) {
        return employeetrainMapper.deleteByIds(ids);
    }

}
