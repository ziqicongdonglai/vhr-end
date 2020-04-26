package com.example.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * position
 * @author 
 */
@Data
@ApiModel(value = "职位对象")
public class Position implements Serializable {
    @ApiModelProperty(notes = "职位ID", name = "id", required = true, dataType = "Integer", value = "1")
    private Integer id;

    /**
     * 职位
     */
    @ApiModelProperty(notes = "职位名称", name = "name", required = true, dataType = "String", value = "职位名称")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "Asia/Shanghai")
    @ApiModelProperty(notes = "职位创建时间", name = "createDate", required = true, dataType = "Date", value = "1970-01-01 00:00:00")
    private Date createDate;

    @ApiModelProperty(notes = "职位权限", name = "enabled", required = true, dataType = "BIT", value = "1")
    private Boolean enabled;

    private static final long serialVersionUID = 1L;
}