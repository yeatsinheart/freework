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
 * 日工资签约表
 * </p>
 *
 * @author yeats
 * @since 2019-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "DailywagesAgreement对象", description = "日工资签约表  f_tbl_info_activity_dailywages_agreement")
public class DailywagesAgreement implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userId;

    @ApiModelProperty(value = "创建日期 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "有效起始日期 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime validDate;

    @ApiModelProperty(value = "状态及操作限制1.已签约（默认）：查看，解约2.已解约：查看4.解约中：查看5.签约失败：查看")
    private Integer status;

    @ApiModelProperty(value = "上级ID")
    private String parentId;

    @ApiModelProperty(value = "上级用户名")
    private String parentName;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "奖励配置")
    private String rule;

    @ApiModelProperty(value = "协议内容")
    private String content;

    @ApiModelProperty(value = "更新时间 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "顶层可设置的最高日工资比例")
    private Integer amountMax;

    @ApiModelProperty(value = "顶层可设置的最低日工资比例")
    private Integer amountMin;


}
