package com.price.doc.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @program: freework
 * @description: this is a
 * @author: Yeats
 * @create: 2019-06-03 16:47
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "IntraAgreementMineReq对象", description = "日工资签约列表请求参数  f_tbl_info_activity_dailywages_agreement")
public class IntraAgreementMineReq {
    @ApiModelProperty(value = "状态为已签约的签约协议ID",required = true)
    private Long id;
}
