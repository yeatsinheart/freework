package com.price.db.service;

import com.price.db.dto.Column;
import com.price.db.dto.Table;
import com.price.db.mapper.ColumnMapper;
import com.price.db.mapper.TableMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @program: freework
 * @description: this is a 数据库表信息服务
 * @author: Yeats
 * @create: 2019-06-04 16:00
 **/
@Service
public class TableInfoService {
    @Resource
    private DataBaseService dataBaseService;

    public List<Table> getAllTables(){
        SqlSessionFactory sqlSessionFactory = dataBaseService.getDbConnection("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/global_3rd_db?useUnicode=true&serverTimezone=UTC&useSSL=false&autoReconnect=true&characterEncoding=utf-8",
                "root","mysql");
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        TableMapper tableMapper = template.getMapper(TableMapper.class);
        List<Table> tableList = tableMapper.getAllTables();

        //提交事务
        template.commit();
        //关闭session
        template.close();
        return tableList;
    }
    public List<Column> getAllColumns(String tableName){
        SqlSessionFactory sqlSessionFactory = dataBaseService.getDbConnection("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/global_3rd_db?useUnicode=true&serverTimezone=UTC&useSSL=false&autoReconnect=true&characterEncoding=utf-8",
                "root","mysql");
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        ColumnMapper columnMapper = template.getMapper(ColumnMapper.class);
        List<Column> tableList = columnMapper.getAllColumns(tableName);
        //提交事务
        template.commit();
        //关闭session
        template.close();
        return tableList;
    }

}
