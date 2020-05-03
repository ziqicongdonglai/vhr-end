package com.example.vhr.controller.system.basic;

import com.example.vhr.model.Joblevel;
import com.example.vhr.model.RespBean;
import com.example.vhr.service.system.basic.JobLevelService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/26 18:00
 * @description
 */
@RestController
@Api(tags = {"职称 API"}, produces = "http")
@SwaggerDefinition(tags = {
        @Tag(name = "职称 API", description = "职称管理的API接口")
})
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    @ApiOperation(value = "职称列表",
            notes = "完整的职称内容列表",
            produces = "application/json, application/xml")
    public RespBean getAllJobLevel() {
        List<Joblevel> jobLevels = jobLevelService.getAllJobLevel();
        return RespBean.ok("获取成功", jobLevels);
    }

    @PostMapping("/")
    @ApiOperation(value = "添加职称", notes = "根据参数创建职称")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel) {
        if (jobLevelService.addJobLevel(joblevel) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    @ApiOperation(value = "更新职称", notes = "根据参数更新职称")
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 102, message = "禁止访问"),
            @ApiResponse(code = 103, message = "请求路径不存在"),
            @ApiResponse(code = 104, message = "服务器内部错误"),
            @ApiResponse(code = 200, message = "成功")
    })
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel) {
        if (jobLevelService.updateJobLevel(joblevel) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除职称", notes = "根据id删除职称")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevel(id) == 1) {
            return  RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    @ApiOperation(value = "批量删除职称", notes = "根据id批量删除职称")
    @ApiImplicitParam(name = "ids", value = "id数组", required = true)
    public RespBean deleteJobLevel(Integer[] ids) {
        if (jobLevelService.deleteJobLevel(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
