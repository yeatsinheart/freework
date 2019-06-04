package com.price.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @program: freework
 * @description: this is a mybatis 多数据源配置
 * @author: Yeats
 * @create: 2019-06-04 14:23
 **/

//@Configuration
//@MapperScan(basePackages = {"titan.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisMultiDBConfig {

    @Bean(name = "titanMasterDS")
    @ConfigurationProperties(prefix = "spring.datasource.titan-master") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }




    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }





    @Autowired
    @Qualifier("titanMasterDS")
    private DataSource ds1;


    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        // 使用titan数据源, 连接titan库
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds1);
        return factoryBean.getObject();
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1());
        return template;
    }
}
