package com.price.doc.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;


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
@ApiModel(value = "DailywagesAgreementBindReq对象", description = "日工资签约表  f_tbl_info_activity_dailywages_agreement")
public class DailywagesAgreementBindReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "用户类型", required = true)
    private String userType;
    @ApiModelProperty(value = "上级ID", required = true)
    private String parentId;
    @ApiModelProperty(value = "上级用户名", required = true)
    private String parentName;
    @ApiModelProperty(value = "上级用户类型", required = true)
    private String parentType;


    @ApiModelProperty(value = "奖励配置JSON", required = true)
    private List<AgreementRule> rule;
    @ApiModelProperty(value = "协议内容", required = true)
    private String content;

    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value = "AgreementRule对象", description = "工资规则 ")
    public class AgreementRule {
        @ApiModelProperty(value = "序号", required = true)
        private int index;
        @ApiModelProperty(value = "日总有效投注额", required = true)
        private int amount;
        @ApiModelProperty(value = "日工资比例", required = true)
        private int rebate;
    }

   /* @ApiModelProperty(value = "创建日期 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;*/

   /* @ApiModelProperty(value = "状态及操作限制1.已签约（默认）：查看，解约2.已解约：查看4.解约中：查看5.签约失败：查看")
    private Integer status;*/
   /* @ApiModelProperty(value = "有效起始日期 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime validDate;*/

   /* @ApiModelProperty(value = "顶层可设置的最高日工资比例")
    private Integer amountMax;

    @ApiModelProperty(value = "顶层可设置的最低日工资比例")
    private Integer amountMin;*/


}
