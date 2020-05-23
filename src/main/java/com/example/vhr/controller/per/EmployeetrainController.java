package com.example.vhr.controller.per;

import com.example.vhr.model.Employeetrain;
import com.example.vhr.model.RespBean;
import com.example.vhr.service.per.EmployeetrainService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/5/24 0:05
 * @description
 */
@RestController
@Api(tags = {"职位培训 API"}, produces = "http")
@SwaggerDefinition(tags = {
        @Tag(name = "员工培训 API", description = "员工培训的API接口")
})
@RequestMapping("/per/train")
public class EmployeetrainController {
    @Autowired
    EmployeetrainService employeetrainService;

    @GetMapping("/")
    @ApiOperation(value = "员工培训列表",
            notes = "完整的员工培训列表",
            produces = "application/json, application/xml")
    public RespBean getAllEmployeetrains() {
        List<Employeetrain> employeetrains = employeetrainService.getAllEmployeetrains();
        return RespBean.ok("获取成功", employeetrains);
    }

    @PostMapping("/")
    @ApiOperation(value = "添加培训记录", notes = "根据参数添加培训记录")
    public RespBean addEmployeetrain(@RequestBody Employeetrain employeetrain) {
        if (employeetrainService.addEmployeetrain(employeetrain) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    @ApiOperation(value = "更新培训记录", notes = "根据参数更新培训记录")
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 102, message = "禁止访问"),
            @ApiResponse(code = 103, message = "请求路径不存在"),
            @ApiResponse(code = 104, message = "服务器内部错误"),
            @ApiResponse(code = 200, message = "成功")
    })
    public RespBean updateEmployeetrain(@RequestBody Employeetrain employeetrain) {
        if (employeetrainService.updateEmployeetrain(employeetrain) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除培训记录", notes = "根据id删除培训记录")
    public RespBean deleteEmployeetrain(@PathVariable Integer id) {
        if (employeetrainService.deleteEmployeetrain(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    @ApiOperation(value = "批量删除培训记录", notes = "根据id数组批量删除培训记录")
    @ApiImplicitParam(name = "ids", value = "id数组", required = true)
    public RespBean deletePosition(Integer[] ids) {
        if (employeetrainService.deleteEmployeetrain(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
