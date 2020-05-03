package com.example.vhr.service.system.basic;

import com.example.vhr.mapper.JoblevelMapper;
import com.example.vhr.model.Joblevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/26 17:53
 * @description
 */
@Service
public class JobLevelService {
    @Resource
    JoblevelMapper joblevelMapper;

    public List<Joblevel> getAllJobLevel() {
        return joblevelMapper.selectAllJobLevel();
    }

    public Integer addJobLevel(Joblevel joblevel) {
        joblevel.setEnabled(true);
        joblevel.setCreateDate(new Date());
        return joblevelMapper.insertSelective(joblevel);
    }

    public Integer updateJobLevel(Joblevel joblevel) {
        return joblevelMapper.updateByPrimaryKeySelective(joblevel);
    }

    public Integer deleteJobLevel(Integer id) {
        return joblevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevel(Integer[] ids) {
        return joblevelMapper.deleteByIds(ids);
    }
}
