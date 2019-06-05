package com.price.db.mapper;

import com.price.db.dto.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface TableMapperMysql  extends TableMapper{
    @Select("SELECT \n" +
            "    table_name tableName,\n" +
            "    engine,\n" +
            "    table_comment tableComment,\n" +
            "    create_time createTime\n" +
            "FROM\n" +
            "    information_schema.tables\n" +
            "WHERE\n" +
            "    table_schema = (SELECT DATABASE()) ORDER BY createTime ")
    @Results({
            @Result(property = "tableName", column = "tableName", javaType = String.class),
            @Result(property = "engine", column = "engine", javaType = String.class),
            @Result(property = "tableComment", column = "tableComment", javaType = String.class),
            @Result(property = "createTime", column = "createTime", javaType = LocalDateTime.class)
    })
    List<Table> getAllTables();
}
