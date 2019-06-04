package com.price.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @program: freework
 * @description: this is a 数据源配置
 * @author: Yeats
 * @create: 2019-06-04 14:45
 **/
//@Configuration
public class DataSourceConfig  implements TransactionManagementConfigurer {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder factory = DataSourceBuilder
                .create()
                .driverClassName("driverName")
                .url("url")
                .username("userName")
                .password("pwd");
      /*  if (this.properties.getType() != null) {
            factory.type(this.properties.getType());
        }*/
        return factory.build();
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }

}
