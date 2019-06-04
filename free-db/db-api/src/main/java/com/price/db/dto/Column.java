package com.price.db.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: freework
 * @description: this is a 表信息，目前只针对mysql
 * @author: Yeats
 * @create: 2019-06-03 14:15
 **/
@Data
public class Column implements Serializable {

    private static final long serialVersionUID = 1L;

    private String columnName;
    private String dataType;
    private String columnComment;
    private String columnKey;
    private String extra;


}
