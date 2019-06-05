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

import javax.sql.DataSource;
import java.util.List;

/**
 * @program: freework
 * @description: this is a 数据库表创建服务
 * @author: Yeats
 * @create: 2019-06-04 16:00
 **/
@Service
public class DataBaseService {
    public SqlSessionFactory getDbConnection(String driverName, String url, String userName, String pwd){
        DataSource dataSource = DataSourceBuilder
                .create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/global_3rd_db?useUnicode=true&serverTimezone=UTC&useSSL=false&autoReconnect=true&characterEncoding=utf-8")
                .username("root")
                .password("mysql").build();
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        Configuration configuration = new Configuration();
        configuration.addMappers("com.price.db.mapper");
        factoryBean.setConfiguration(configuration);
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
    public boolean createTable(){
        return false;
    }
    public boolean createTables(){
        return false;
    }
}
