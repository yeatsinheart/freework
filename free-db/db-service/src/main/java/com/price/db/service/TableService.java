package com.price.db.service;

import com.price.db.dto.Column;
import com.price.db.dto.Table;
import com.price.db.mapper.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: freework
 * @description: this is a 数据库表信息服务
 * @author: Yeats
 * @create: 2019-06-04 16:00
 **/
@Service
public class TableService {
    @Resource
    private DataBaseService dataBaseService;

    public Class getTableMapper(String driverName) {
        if (driverName.equals("org.postgresql.Driver")) {
            return TableMapperPostgre.class;
        }
        return null;
    }
    public Class getColumnMapper(String driverName) {
        if (driverName.equals("org.postgresql.Driver")) {
            return ColumnMapperPostgre.class;
        }
        return null;
    }

    public List<Table> getAllTables(String driverName, String url, String userName, String pwd) {
        SqlSessionFactory sqlSessionFactory = dataBaseService.getDbConnection(driverName, url, userName, pwd);
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        TableMapper tableMapperMysql = (TableMapper) template.getMapper(getTableMapper(driverName));
        List<Table> tableList = tableMapperMysql.getAllTables();
        //提交事务
       /* template.commit();
        //关闭session
        template.close();*/
        return tableList;
    }

    public List<Column> getAllColumns(String tableName, String driverName, String url, String userName, String pwd) {
        SqlSessionFactory sqlSessionFactory = dataBaseService.getDbConnection(driverName, url, userName, pwd);
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        ColumnMapper columnMapperMysql = (ColumnMapper) template.getMapper( getColumnMapper(driverName));
        List<Column> columnList = columnMapperMysql.getAllColumns(tableName);
        //提交事务
       /* template.commit();
        //关闭session
        template.close();*/
        return columnList;
    }

}
