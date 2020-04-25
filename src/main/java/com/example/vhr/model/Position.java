package com.example.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * position
 * @author 
 */
@Data
public class Position implements Serializable {
    private Integer id;

    /**
     * 职位
     */
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "Asia/Shanghai")
    private Date createDate;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;
}