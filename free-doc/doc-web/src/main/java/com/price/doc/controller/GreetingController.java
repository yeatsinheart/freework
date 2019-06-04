package com.price.doc.controller;

/**
 * @program: freework
 * @description: this is a
 * @author: Yeats
 * @create: 2019-06-03 16:31
 **/

import com.alibaba.fastjson.JSON;
import com.price.doc.dto.DailywagesAgreement;
import com.price.doc.dto.DailywagesDetail;
import com.price.doc.dto.DailywagesOperate;
import com.price.doc.dto.DailywagesOperateLog;
import com.price.doc.dto.req.*;
import com.price.doc.dto.response.BaseResponse;
import com.price.doc.dto.response.BaseResponseList;
import com.price.doc.service.DocService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class GreetingController {
    @Autowired
    DocService docService;

    @GetMapping("/test")
    @ApiOperation(value = "接口给")
    public BaseResponseList<DailywagesAgreement> test() {
       log.info(JSON.toJSONString(docService.tableList()));
       return null;
    };

    /*@PostMapping("/intra/dailyact/list.json")
    @ApiOperation(value = "后台-查看签约列表：请求参数：")
    public BaseResponseList<DailywagesAgreement> listIntraReq(IntraAgreementListReq req) {
        return null;
    }*/

    @PostMapping("/intra/dailyact/listRes.json")
    @ApiOperation(value = "后台-查看签约列表 响应参数")
    public BaseResponseList<DailywagesAgreement> listIntraRes(DailywagesAgreement req) {
        return null;
    }
/*
    @PostMapping("/intra/dailyact/details.json")
    @ApiOperation(value = "后台-查看签约详情 请求参数：")
    public BaseResponse<DailywagesAgreement> getIntraReq(IntraAgreementDetailReq req) {
        return null;
    }*/

    @PostMapping("/intra/dailyact/detailsRes.json")
    @ApiOperation(value = "后台-查看签约详情 响应参数：")
    public BaseResponse<DailywagesAgreement> getIntraRes(DailywagesAgreement req) {
        return null;
    }



/*    @PostMapping("/intra/dailyact/checkList.json")
    @ApiOperation(value = "后台-审核签约列表")
    public BaseResponseList<DailywagesOperate> checkList(IntraAgreementCheckListReq req) {
        return null;
    }*/

    @PostMapping("/intra/dailyact/checkListRes.json")
    @ApiOperation(value = "后台-审核签约列表 响应参数")
    public BaseResponseList<DailywagesOperate> checkListRes(DailywagesOperate req) {
        return null;
    }


  /*  @PostMapping("/intra/dailyact/check.json")
    @ApiOperation(value = "后台-审核操作")
    public BaseResponse<DailywagesAgreement> checkList(IntraAgreementCheckReq req) {
        return null;
    }*/
    @PostMapping("/intra/dailyact/checkRes.json")
    @ApiOperation(value = "后台-审核操作 响应参数")
    public BaseResponse<DailywagesAgreement> checkListRes(DailywagesAgreement req) {
        return null;
    }

   /* @PostMapping("/intra/dailyact/settleList.json")
    @ApiOperation(value = "后台-派发列表")
    public BaseResponseList<DailywagesDetail> settleList(IntraAgreementSettleListReq req) {
        return null;
    }*/
    @PostMapping("/intra/dailyact/settleListRes.json")
    @ApiOperation(value = "后台-派发列表Res")
    public BaseResponseList<DailywagesDetail> settleListRes(DailywagesDetail req) {
        return null;
    }

    /*@PostMapping("/info/dailyact/conf.json")
    @ApiOperation(value = "前台-我的日工资-我的奖励内容")
    public BaseResponse<DailywagesAgreement> infoConf(IntraAgreementMineReq req) {
        return null;
    }*/
    @PostMapping("/info/dailyact/confRes.json")
    @ApiOperation(value = "前台-我的日工资-我的奖励内容Res")
    public BaseResponse<DailywagesAgreement> infoConfRes(DailywagesAgreement req) {
        return null;
    }

    /*@PostMapping("/intra/dailyact/mySettleList.json")
    @ApiOperation(value = "前台-我的派发列表")
    public BaseResponseList<DailywagesDetail> mySettleList(IntraAgreementSettleListReq req) {
        return null;
    }*/
    @PostMapping("/intra/dailyact/mySettleListRes.json")
    @ApiOperation(value = "前台-我的派发列表Res")
    public BaseResponseList<DailywagesDetail> mySettleListRes(DailywagesDetail req) {
        return null;
    }
    /*@PostMapping("/intra/dailyact/subSettleList.json")
    @ApiOperation(value = "前台-下级派发列表")
    public BaseResponseList<DailywagesDetail> subSettleList(IntraAgreementSettleListReq req) {
        return null;
    }*/
    @PostMapping("/intra/dailyact/subSettleListRes.json")
    @ApiOperation(value = "前台-下级派发列表Res")
    public BaseResponseList<DailywagesDetail> subSettleListRes(DailywagesDetail  req) {
        return null;
    }

    /*@PostMapping("/intra/dailyact/subList.json")
    @ApiOperation(value = "前台-下级契约列表")
    public BaseResponseList<DailywagesDetail> subList(IntraAgreementSubListReq req) {
        return null;
    }*/
    @PostMapping("/intra/dailyact/subListRes.json")
    @ApiOperation(value = "前台-下级契约列表Res")
    public BaseResponseList<DailywagesDetail> subListRes(DailywagesDetail  req) {
        return null;
    }

   /* @PostMapping("/intra/dailyact/subDetail.json")
    @ApiOperation(value = "前台-下级契约详情")
    public BaseResponseList<DailywagesDetail> subDetail(IntraAgreementSubDetailReq req) {
        return null;
    }*/
    @PostMapping("/intra/dailyact/subDetailRes.json")
    @ApiOperation(value = "前台-下级契约详情Res")
    public BaseResponseList<DailywagesDetail> subDetailRes(DailywagesDetail req) {
        return null;
    }

   /* @PostMapping("/info/dailyact/unbind.json")
    @ApiOperation(value = "前台-解约申请")
    public BaseResponseList unbind(IntraAgreementDetailReq req) {
        return null;
    }*/
    @PostMapping("/info/dailyact/unbindRes.json")
    @ApiOperation(value = "前台-解约申请Res")
    public BaseResponseList unbindRes(BaseResponseList req) {
        return null;
    }

    /*@PostMapping("/info/dailyact/logList.json")
    @ApiOperation(value = "前台-查看签约日志")
    public BaseResponseList<DailywagesOperateLog> logList(IntraAgreementDetailReq req) {
        return null;
    }*/
    @PostMapping("/info/dailyact/logListRes.json")
    @ApiOperation(value = "前台-查看签约日志Res")
    public BaseResponseList<DailywagesOperateLog> logListRes(DailywagesOperateLog  req) {
        return null;
    }

    /*@PostMapping("/info/dailyact/bind.json")
    @ApiOperation(value = "前台-发起/修改契约")
    public BaseResponse bind(DailywagesAgreementBindReq req) {
        return null;
    }*/
    @PostMapping("/info/dailyact/bindRes.json")
    @ApiOperation(value = "前台-发起/修改契约 响应")
    public BaseResponse bindRes(BaseResponse req) {
        return null;
    }
}
