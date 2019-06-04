package com.price.doc.controller;

import java.util.List;

/**
 * @program: freework
 * @description: this is a
 * @author: Yeats
 * @create: 2019-06-03 17:44
 **/
public class SwaggerDoc {

    /**
     * 大标题
     */
    private String title;
    /**
     * 小标题
     */
    private String tag;
    /**
     * url
     */
    private String url;

    /**
     * 响应参数格式
     */
    private String responseForm;

    /**
     * 请求方式
     */
    private String requestType;

    /**
     * 请求体
     */
    private List<SwaggerRequest> requestList;

    /**
     * 返回体
     */
    private List<SwaggerResponse> responseList;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 返回值
     */
    private String responseParam;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResponseForm() {
        return responseForm;
    }

    public void setResponseForm(String responseForm) {
        this.responseForm = responseForm;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public List<SwaggerRequest> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<SwaggerRequest> requestList) {
        this.requestList = requestList;
    }

    public List<SwaggerResponse> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<SwaggerResponse> responseList) {
        this.responseList = responseList;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam;
    }
}

