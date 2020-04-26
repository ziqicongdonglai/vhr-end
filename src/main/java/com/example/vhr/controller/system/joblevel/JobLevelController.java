package com.example.vhr.controller.system.joblevel;

import com.example.vhr.model.Joblevel;
import com.example.vhr.model.RespBean;
import com.example.vhr.service.system.joblevel.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/26 18:00
 * @description
 */
@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public RespBean getAllJobLevel() {
        List<Joblevel> joblevels = jobLevelService.getAllJobLevel();
        return RespBean.ok("获取成功", joblevels);
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel) {
        if (jobLevelService.addJobLevel(joblevel) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel) {
        if (jobLevelService.updateJobLevel(joblevel) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/id")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevel(id) == 1) {
            return  RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevel(Integer[] ids) {
        if (jobLevelService.deleteJobLevel(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
