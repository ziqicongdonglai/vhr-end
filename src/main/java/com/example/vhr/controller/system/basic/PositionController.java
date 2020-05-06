package com.example.vhr.controller.system.basic;

import com.example.vhr.model.Position;
import com.example.vhr.model.RespBean;
import com.example.vhr.service.system.basic.PositionService;
import com.example.vhr.utils.PoiUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/23 11:29
 * @description
 */
@RestController
@Api(tags = {"职位 API"}, produces = "http")
@SwaggerDefinition(tags = {
        @Tag(name = "职位 API", description = "职位管理的API接口")
})
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    //@GetMapping("/")
    //@ApiOperation(value = "职位列表",
    //        notes = "完整的职位内容列表",
    //        produces = "application/json, application/xml")
    //public RespBean getAllPosition() {
    //    List<Position> positions = positionService.getAllPosition();
    //    return RespBean.ok("获取成功", positions);
    //}

    @GetMapping("/")
    @ApiOperation(value = "分页获取职位", notes = "职位信息列表")
    public RespBean getPositionByPage(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "5") Integer size){
        PageInfo<Position> positions = positionService.getPositionByPage(page, size);
        return RespBean.ok("获取成功", positions);
    }

    @PostMapping("/")
    @ApiOperation(value = "添加职位", notes = "根据参数创建职位")
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    @ApiOperation(value = "更新职位", notes = "根据参数更新职位")
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 102, message = "禁止访问"),
            @ApiResponse(code = 103, message = "请求路径不存在"),
            @ApiResponse(code = 104, message = "服务器内部错误"),
            @ApiResponse(code = 200, message = "成功")
    })
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除职位", notes = "根据id删除职位")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.deletePosition(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    @ApiOperation(value = "批量删除职位", notes = "根据id数组批量删除职位")
    @ApiImplicitParam(name = "ids", value = "id数组", required = true)
    public RespBean deletePosition(Integer[] ids) {
        if (positionService.deletePosition(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出数据", notes = "将所有职位导出搭配Excel")
    public ResponseEntity<byte[]> exportData() {
        //List<Position> positions = positionService.getPositionByPage(null, null).getList();
        List<Position> positions = positionService.getAllPosition();
        return PoiUtils.exportData(positions);
    }

    @GetMapping("/import")
    @ApiOperation(value = "导入数据", notes = "导入Excel数据")
    public RespBean importData(MultipartFile file) throws IOException {
        //file.transferTo(new File("e:\\position.xlsx"));
        List<Position> positions = PoiUtils.importData(file);
        if (positionService.addPositions(positions) == positions.size()) {
            return RespBean.ok("导入成功");
        }
        return RespBean.ok("导入失败");
    }

}
