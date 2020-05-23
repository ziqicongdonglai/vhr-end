package com.example.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "员工培训对象")
public class Employeetrain implements Serializable {
    @ApiModelProperty(notes = "员工培训ID", name = "id", required = true, dataType = "Integer", value = "1")
    private Integer id;
    @ApiModelProperty(notes = "员工编号", name = "eid", required = true, dataType = "Integer", value = "1")
    private Integer eid;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @ApiModelProperty(notes = "培训日期", name = "trainDate", required = true, dataType = "Date", value = "1970-01-01")
    private Date trainDate;
    @ApiModelProperty(notes = "培训内容", name = "trainContent", required = true, dataType = "String", value = "培训内容")
    private String trainContent;
    @ApiModelProperty(notes = "备注", name = "remark", required = true, dataType = "String", value = "备注")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent == null ? null : trainContent.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}