package com.price.db.mapper;

import com.price.db.dto.Column;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ColumnMapperPostgre extends ColumnMapper{
    @Select("SELECT A.attname AS columnName, format_type(A.atttypid, A.atttypmod) AS dataType,col_description(A.attrelid, A.attnum) AS columnComment, (CASE C.contype WHEN 'p' THEN 'PRI' ELSE '' END) AS columnKey  " +
            "FROM pg_attribute A LEFT JOIN pg_constraint C ON A.attnum = C.conkey[1] AND A.attrelid = C.conrelid  " +
            "WHERE  A.attrelid = #{tableName}::regclass AND A.attnum > 0 AND NOT A.attisdropped ORDER  BY A.attnum ")
    @Results({
            @Result(property = "columnName", column = "columnName", javaType = String.class),
            @Result(property = "dataType", column = "dataType", javaType = String.class),
            @Result(property = "columnComment", column = "columnComment", javaType = String.class),
            @Result(property = "columnKey", column = "columnKey", javaType = String.class)
    })
    List<Column> getAllColumns(String tableName);
}
