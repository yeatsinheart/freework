package com.price.db.mapper;

import com.price.db.dto.Column;

import java.util.List;

public interface ColumnMapper {
    List<Column> getAllColumns(String tableName);
}
