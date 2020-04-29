package com.example.vhr.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * role
 * @author 
 */
@Data
@ApiModel(value = "权限对象")
public class Role implements Serializable {
    @ApiModelProperty(notes = "权限ID", name = "id", required = true, dataType = "Integer", value = "1")
    private Integer id;
    @ApiModelProperty(notes = "权限名称", name = "name", required = true, dataType = "String", value = "权限名称")
    private String name;

    /**
     * 角色名称
     */
    @ApiModelProperty(notes = "角色名称", name = "nameZh", required = true, dataType = "String", value = "角色名称")
    private String nameZh;

    private static final long serialVersionUID = 1L;
}