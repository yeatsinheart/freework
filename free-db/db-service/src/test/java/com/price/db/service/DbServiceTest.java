package com.price.db.service;

import com.alibaba.fastjson.JSON;
import com.price.db.dto.Column;
import com.price.db.dto.Table;
import com.price.db.mapper.TableMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {

    @Autowired
    private TableInfoService tableInfoService;
    @Test
    public void getAllTables() {
        List<Table> tableList = tableInfoService.getAllTables();
        for (Table tab : tableList) {
            List<Column> columnList = tableInfoService.getAllColumns(tab.getTableName());
            System.out.println(JSON.toJSONString(columnList));
        }
    }

    @Test
    public void getAllColumns() {
        SqlSessionFactory sqlSessionFactory = tableInfoService.getDbConnection("com.mysql.cj.jdbc.Driver",
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


    }
}