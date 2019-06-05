package com.price.db.mapper;

import com.price.db.dto.Column;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ColumnMapperMysql extends ColumnMapper{
    @Select("SELECT \n" +
            "    column_name columnName,\n" +
            "    data_type dataType,\n" +
            "    column_comment columnComment,\n" +
            "    column_key columnKey,\n" +
            "    extra\n" +
            "FROM\n" +
            "    information_schema.columns\n" +
            "WHERE\n" +
            "    table_name = #{tableName}" +
            "        AND table_schema = (SELECT DATABASE())\n" +
            "ORDER BY ordinal_position ")
    @Results({
            @Result(property = "columnName", column = "columnName", javaType = String.class),
            @Result(property = "dataType", column = "dataType", javaType = String.class),
            @Result(property = "columnComment", column = "columnComment", javaType = String.class),
            @Result(property = "columnKey", column = "columnKey", javaType = String.class),
            @Result(property = "extra", column = "extra", javaType = String.class)
    })
    List<Column> getAllColumns(String tableName);
}
