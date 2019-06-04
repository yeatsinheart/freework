package com.price.doc.dto.doc;

/**
 * @program: freework
 * @description: this is a 对象属性定义
 * @author: Yeats
 * @create: 2019-06-04 11:31
 **/
public class PropertyConfig {
    private String name;
    //基本类型还是引用类型，如果是引用类型那么就再去获取引用
    private String type;
    private String defaultValue;
    private String desc;
    private boolean required;
}
