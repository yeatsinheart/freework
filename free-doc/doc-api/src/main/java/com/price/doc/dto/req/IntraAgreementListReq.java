package com.price.doc.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value = "IntraAgreementListReq对象", description = "日工资签约列表请求参数  f_tbl_info_activity_dailywages_agreement")
public class IntraAgreementListReq {

    @ApiModelProperty(value = "直属非直属 1直属2非直属")
    private int type;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "创建日期 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "有效起始日期 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime validDate;

    @ApiModelProperty(value = "状态及操作限制 1.已签约：查看，解约 2.已解约：查看 4.解约中：查看 5.签约失败：查看")
    private Integer status;
    @ApiModelProperty(value = "每页展示数量")
    private Integer pageSize;
    @ApiModelProperty(value = "页码")
    private Integer pageIndex;
}
