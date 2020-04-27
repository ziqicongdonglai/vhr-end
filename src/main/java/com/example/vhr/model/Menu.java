package com.example.vhr.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * menu
 * @author 
 */
@Data
@ApiModel(value = "菜单对象")
public class Menu implements Serializable {
    @ApiModelProperty(notes = "菜单ID", name = "id", required = true, dataType = "Integer", value = "1")
    private Integer id;
    @ApiModelProperty(notes = "菜单Url", name = "url", required = true, dataType = "String", value = "/")
    private String url;
    @ApiModelProperty(notes = "菜单Path", name = "path", required = true, dataType = "String", value = "/home")
    private String path;
    @ApiModelProperty(notes = "菜单组件", name = "component", required = true, dataType = "String", value = "Home")
    private String component;
    @ApiModelProperty(notes = "菜单名称", name = "name", required = true, dataType = "String", value = "菜单名称")
    private String name;
    @ApiModelProperty(notes = "菜单图标", name = "iconCls", required = true, dataType = "String", value = "菜单图标")
    private String iconCls;

    //private Boolean keepalive;
    //
    //private Boolean requireauth;
    @ApiModelProperty(notes = "菜单parentId", name = "parentId", required = true, dataType = "Integer", value = "1")
    private Integer parentId;
    @ApiModelProperty(notes = "菜单enabled", name = "enabled", required = true, dataType = "BIT", value = "1")
    private Boolean enabled;

    private Meta meta;

    private List<Menu> children;

    private List<Role> roles;
}