package com.price.doc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.price.doc.controller.SwaggerDoc;
import com.price.doc.controller.SwaggerRequest;
import com.price.doc.controller.SwaggerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @program: freework
 * @description: this is a
 * @author: Yeats
 * @create: 2019-06-03 17:48
 **/
@Service
@Slf4j
public class DocService {

    public List<SwaggerDoc> tableList() {
        List<SwaggerDoc> list = new LinkedList();
        try {
            ClassLoader classLoader = DocService.class.getClassLoader();
            URL resource = classLoader.getResource("data.json");
            Map map = new ObjectMapper().readValue(resource, Map.class);
            //得到host，用于模拟http请求
            String host = String.valueOf(map.get("host"));
            //解析paths   URL
            LinkedHashMap<String, LinkedHashMap> paths = (LinkedHashMap) map.get("paths");

            if (paths != null) {
                Iterator<Map.Entry<String, LinkedHashMap>> iterator = paths.entrySet().iterator();
                while (iterator.hasNext()) {
                    SwaggerDoc SwaggerDoc = new SwaggerDoc();
                    List<SwaggerRequest> requestList = new LinkedList<SwaggerRequest>();
                    String requestType = "";

                    Map.Entry<String, LinkedHashMap> next = iterator.next();
                    String url = next.getKey();//得到url

                    LinkedHashMap<String, LinkedHashMap> value = next.getValue();
                    //得到请求方式，输出结果类似为 get/post/delete/put 这样
                    Set<String> requestTypes = value.keySet();
                    for (String str : requestTypes) {
                        requestType += str + "/";
                    }

                    Iterator<Map.Entry<String, LinkedHashMap>> it2 = value.entrySet().iterator();
                    //解析请求
                    Map.Entry<String, LinkedHashMap> get = it2.next();//得到get
                    LinkedHashMap getValue = get.getValue();
                    String title = (String) ((List) getValue.get("tags")).get(0);//得到大标题
                    String tag = String.valueOf(getValue.get("summary"));
                    System.out.println("接口：" + tag);
                    System.out.println("链接：" + url);
                    System.out.println("请求方式：" + requestType);
                    //请求体
                    System.out.println("请求参数：");
                    ArrayList parameters = (ArrayList) getValue.get("parameters");
                    if (parameters != null && parameters.size() > 0) {
                        for (int i = 0; i < parameters.size(); i++) {
                            SwaggerRequest SwaggerRequest = new SwaggerRequest();
                            LinkedHashMap<String, Object> param = (LinkedHashMap) parameters.get(i);
                            SwaggerRequest.setDescription(String.valueOf(param.get("description")));
                            SwaggerRequest.setName(String.valueOf(param.get("name")));
                            SwaggerRequest.setType(String.valueOf(param.get("type")));
                            SwaggerRequest.setParamType(String.valueOf(param.get("in")));
                            SwaggerRequest.setRequire((Boolean) param.get("required"));
                            System.out.println(SwaggerRequest.getName() +"，"+SwaggerRequest.getDescription()+ ", 类型：" + SwaggerRequest.getType() + "，必传：" + SwaggerRequest.getRequire());
                            requestList.add(SwaggerRequest);
                        }
                    }
                    //返回体，比较固定
                    List<SwaggerResponse> responseList = listResponse();
                    //模拟一次HTTP请求,封装请求体和返回体，如果是Restful的文档可以再补充
                    try {
                        if (requestType.contains("post")) {
                            Map<String, String> stringStringMap = toPostBody(requestList);
                            SwaggerDoc.setRequestParam(stringStringMap.toString());
                            /*String post = Httpz.post(host + url, stringStringMap);
                            SwaggerDoc.setResponseParam(post);*/
                        } else if (requestType.contains("get")) {
                            String s = toGetHeader(requestList);
                            SwaggerDoc.setResponseParam(s);
                           /* String getStr = Httpz.get(host + url + s);
                            SwaggerDoc.setResponseParam(getStr);*/
                        }

                        //封装Table
                        SwaggerDoc.setTitle(title);
                        SwaggerDoc.setUrl(url);
                        SwaggerDoc.setTag(tag);
                        SwaggerDoc.setResponseForm("application/json");
                        SwaggerDoc.setRequestType(StringUtils.removeEnd(requestType, "/"));
                        SwaggerDoc.setRequestList(requestList);
                        SwaggerDoc.setResponseList(responseList);
                        list.add(SwaggerDoc);
                    } catch (Exception e) {
                        log.error("这里出错{}", e);
                    }

                }
            }
            return list;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //封装返回信息，可能需求不一样，可以自定义
    private List<SwaggerResponse> listResponse() {
        List<SwaggerResponse> responseList = new LinkedList<SwaggerResponse>();
        responseList.add(new SwaggerResponse("受影响的行数", "counts", null));
        responseList.add(new SwaggerResponse("结果说明信息", "msg", null));
        responseList.add(new SwaggerResponse("是否成功", "success", null));
        responseList.add(new SwaggerResponse("返回对象", "data", null));
        responseList.add(new SwaggerResponse("错误代码", "errCode", null));
        return responseList;
    }

    //封装post请求体
    private Map<String, String> toPostBody(List<SwaggerRequest> list) {
        Map<String, String> map = new HashMap<>(16);
        if (list != null && list.size() > 0) {
            for (SwaggerRequest SwaggerRequest : list) {
                String name = SwaggerRequest.getName();
                String type = SwaggerRequest.getType();
                switch (type) {
                    case "string":
                        map.put(name, "string");
                        break;
                    case "integer":
                        map.put(name, "0");
                        break;
                    case "double":
                        map.put(name, "0.0");
                        break;
                    default:
                        map.put(name, "null");
                        break;
                }
            }
        }
        return map;
    }

    //封装get请求头
    private String toGetHeader(List<SwaggerRequest> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (SwaggerRequest SwaggerRequest : list) {
                String name = SwaggerRequest.getName();
                String type = SwaggerRequest.getType();
                switch (type) {
                    case "string":
                        stringBuffer.append(name + "&=string");
                        break;
                    case "integer":
                        stringBuffer.append(name + "&=0");
                        break;
                    case "double":
                        stringBuffer.append(name + "&=0.0");
                        break;
                    default:
                        stringBuffer.append(name + "&=null");
                        break;
                }
            }
        }
        String s = stringBuffer.toString();
        if ("".equalsIgnoreCase(s)) {
            return "";
        }
        return "?" + StringUtils.removeStart(s, "&");
    }
}

