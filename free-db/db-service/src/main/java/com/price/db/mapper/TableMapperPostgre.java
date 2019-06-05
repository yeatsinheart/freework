package com.price.db.mapper;

import com.price.db.dto.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface TableMapperPostgre extends TableMapper{
    @Select("SELECT A.tablename, obj_description(relfilenode, 'pg_class') AS comments \n" +
            "FROM pg_tables A, pg_class B \n" +
            "WHERE A.schemaname='public' AND A.tablename = B.relname")
    @Results({
            @Result(property = "tableName", column = "tablename", javaType = String.class),
            @Result(property = "engine", column = "engine", javaType = String.class),
            @Result(property = "tableComment", column = "comments", javaType = String.class),
            @Result(property = "createTime", column = "createTime", javaType = LocalDateTime.class)
    })
    List<Table> getAllTables();
}
