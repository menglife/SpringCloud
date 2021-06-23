package com.zmn.springcloud.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class TitleBean {
    @ApiModelProperty(value = "表格字段")
    private String itemName;
    @ApiModelProperty(value = "工程Id")
    private Integer projectId;
}
