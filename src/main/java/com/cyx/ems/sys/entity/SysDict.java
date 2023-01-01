package com.cyx.ems.sys.entity;

import com.cyx.ems.common.mybaits.entity.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysDict extends Entity {


    /**
     *  类型
     */
    @ApiModelProperty(name="字典类型：S-系统，U-自定义",value = "U",allowableValues = "S,U",required=true,position=1)
    private String dictType="U";

    /**
     * 字典名称
     */
    @ApiModelProperty(name = "字典名称",required=true,position=2)
    private String dictName;

    /**
     * 字典编码
     */
    @ApiModelProperty(name = "字典编码",required=true,position=3)
    private String dictCode;

    /**
     * 描述
     */
    @ApiModelProperty(name = "字典描述",required=true,position=4)
    private String dictDesc;


}
