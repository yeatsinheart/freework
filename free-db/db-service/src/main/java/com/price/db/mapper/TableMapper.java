package com.price.db.mapper;

import com.price.db.dto.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

public interface TableMapper {
    List<Table> getAllTables();
}
