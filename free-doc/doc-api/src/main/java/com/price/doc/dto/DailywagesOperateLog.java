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
@ApiModel(value = "DailywagesOperateLog对象", description = "日工资操记录表  f_tbl_info_activity_dailywages_operate_log")
public class DailywagesOperateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "日工资签约ID")
    private Long agreementId;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户id")
    private String userId;
    @ApiModelProperty(value = "创建时间 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    @ApiModelProperty(value = "操作内容")
    private String content;


}
