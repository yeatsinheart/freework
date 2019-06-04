package com.price.doc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * <p>
 * 日工资派发记录表
 * </p>
 *
 * @author yeats
 * @since 2019-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "DailywagesDetail对象", description = "日工资派发记录表 f_tbl_info_activity_dailywages_detail")
public class DailywagesDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "用户名")
    private Long userId;

    @ApiModelProperty(value = "创建日期 yyyy-MM-dd HH:mm:ss")
    private LocalDate createDate;

    @ApiModelProperty(value = "派发状态")
    private Integer status;

    @ApiModelProperty(value = "上级用户名")
    private Long parentId;

    @ApiModelProperty(value = "总有效投注额")
    private Long bet;

    @ApiModelProperty(value = "日工资比例")
    private Integer rebate;

    @ApiModelProperty(value = "日工资总额")
    private Long amountTotal;

    @ApiModelProperty(value = "下级日工资总额")
    private Long amountSub;

    @ApiModelProperty(value = "实发日工资")
    private Long amount;


}
