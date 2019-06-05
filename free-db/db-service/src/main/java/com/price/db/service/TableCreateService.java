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
 * @description: this is a 数据库表创建服务
 * @author: Yeats
 * @create: 2019-06-04 16:00
 **/
@Service
public class TableCreateService {
    @Resource
    private DataBaseService dataBaseService;



}
