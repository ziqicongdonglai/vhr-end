package com.example.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * joblevel
 * @author 
 */
@Data
public class Joblevel implements Serializable {
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    private Object titleLevel;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "Asia/Shanghai")
    private Date createDate;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;
}