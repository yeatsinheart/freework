package com.price.doc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 日工资操记录表
 * </p>
 *
 * @author yeats
 * @since 2019-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "DailywagesOperate对象", description = "日工资操记录表  f_tbl_info_activity_dailywages_operate")
public class DailywagesOperate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "日工资签约ID")
    private Long agreementId;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "用户名")
    private String userId;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "业务类型")
    private String bizType;

    @ApiModelProperty(value = "创建时间 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "审核时间 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "操作状态：默认为空，仅当需要平台审核操作时才有状态值。1成功，2失败")
    private String status;


}
