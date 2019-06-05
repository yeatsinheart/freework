package com.price.db.service;

import com.alibaba.fastjson.JSON;
import com.price.db.dto.Column;
import com.price.db.dto.DB;
import com.price.db.dto.Table;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {

    @Autowired
    private TableService tableService;
    @Test
    public void getAllTables() {
        DB.setWxDB();
        List<Table> tableList = tableService.getAllTables(DB.driver,DB.url,DB.userName,DB.userPW);
        for (Table tab : tableList) {
            List<Column> columnList = tableService.getAllColumns("public."+tab.getTableName(),DB.driver,DB.url,DB.userName,DB.userPW);
            System.out.println(JSON.toJSONString(columnList));
        }
    }

    @Test
    public void getAllColumns() {
    }
}