package com.example.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * joblevel
 * @author 
 */
@Data
@ApiModel(value = "职称对象")
public class Joblevel implements Serializable {
    @ApiModelProperty(notes = "职称ID", name = "id", required = true, dataType = "Integer", value = "1")
    private Integer id;

    /**
     * 职称名称
     */
    @ApiModelProperty(notes = "职称名称", name = "name", required = true, dataType = "String", value = "正高级,副高级,中级,初级,员级")
    private String name;

    @ApiModelProperty(notes = "职称级别", name = "titleLevel", required = true, value = "职称级别")
    private Object titleLevel;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "Asia/Shanghai")
    @ApiModelProperty(notes = "职称创建时间", name = "createDate", required = true, dataType = "Date", value = "1970-01-01 00:00:00")
    private Date createDate;

    @ApiModelProperty(notes = "是否启用", name = "enabled", required = true, dataType = "BIT", value = "1")
    private Boolean enabled;

    private static final long serialVersionUID = 1L;
}