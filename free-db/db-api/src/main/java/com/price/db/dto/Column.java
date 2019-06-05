package com.price.db.dto;

import com.price.db.converts.MySqlTypeConvert;
import com.price.db.converts.PostgreSqlTypeConvert;
import lombok.Data;
import lombok.Getter;

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
    private String javaType;
    private String columnComment;
    private String columnKey;
    private String extra;

    public String getJavaType(String driverName) {
        if (driverName.equals("org.postgresql.Driver")) {
            return new PostgreSqlTypeConvert().processTypeConvert(this.dataType).getType();
        }
        return new MySqlTypeConvert().processTypeConvert(this.dataType).getType();
    }
}
