package com.price.db.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: freework
 * @description: this is a 数据库表信息,目前只针对mysql
 * @author: Yeats
 * @create: 2019-06-03 14:10
 **/
@Data
public class Table implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tableName;
    private String engine;
    private String tableComment;
    private LocalDateTime createTime;


}
