package com.price.db.service;

import com.price.db.dto.Column;
import com.price.db.dto.Table;

import java.util.List;

/**
 * @program: freework
 * @description: this is a 数据库相关信息
 * @author: Yeats
 * @create: 2019-06-03 16:07
 **/
public interface DbInfoService {
    List<Table> getAllTables();
    List<Column> getAllColumns(String tableName);
}
