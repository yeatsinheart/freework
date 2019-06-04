package com.price.doc.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @program: freework
 * @description: this is a
 * @author: Yeats
 * @create: 2019-06-03 16:45
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "IntraAgreementSubListReq对象", description = "下级契约列表请求参数  f_tbl_info_activity_dailywages_agreement")
public class BaseResponseList<T> {
    @ApiModelProperty(value = "响应编码")
    private int result;
    @ApiModelProperty(value = "响应信息")
    private String msg;
    private Object sign;
    @ApiModelProperty(value = "响应内容")
    private RootBean root;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getSign() {
        return sign;
    }

    public void setSign(Object sign) {
        this.sign = sign;
    }

    public RootBean getRoot() {
        return root;
    }

    public void setRoot(RootBean root) {
        this.root = root;
    }

    public  class RootBean {
        /**
         * rowCount : 0
         * amountTotal : 0
         * dataTotal : null
         * dataList : []
         */

        private int rowCount;
        private int amountTotal;
        private Object dataTotal;
        @ApiModelProperty(value = "响应内容列表")
        private List<T> dataList;

        public int getRowCount() {
            return rowCount;
        }

        public void setRowCount(int rowCount) {
            this.rowCount = rowCount;
        }

        public int getAmountTotal() {
            return amountTotal;
        }

        public void setAmountTotal(int amountTotal) {
            this.amountTotal = amountTotal;
        }

        public Object getDataTotal() {
            return dataTotal;
        }

        public void setDataTotal(Object dataTotal) {
            this.dataTotal = dataTotal;
        }

        public List<?> getDataList() {
            return dataList;
        }

        public void setDataList(List<T> dataList) {
            this.dataList = dataList;
        }
    }
}
