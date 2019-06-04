package com.price.doc.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @program: freework
 * @description: this is a
 * @author: Yeats
 * @create: 2019-06-03 16:47
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "IntraAgreementSettleListReq对象", description = "日工资派发列表请求参数  f_tbl_info_activity_dailywages_agreement")
public class IntraAgreementSettleListReq {


    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "开始日期  yyyy-MM-dd HH:mm:ss")
    private LocalDate startDate;

    @ApiModelProperty(value = "结束日期 yyyy-MM-dd HH:mm:ss")
    private LocalDate endDate;

    @ApiModelProperty(value = " 状态值  不填 全部、1 已派发，0 待派发 ")
    private Integer status;
    @ApiModelProperty(value = "每页展示数量")
    private Integer pageSize;
    @ApiModelProperty(value = "页码")
    private Integer pageIndex;
}
