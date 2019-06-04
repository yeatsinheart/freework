package com.price.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.price.db.mapper")
public class DbServiceApplication {
    /** todo 或者直接在 Mapper 类上面添加注解@Mapper */
    public static void main(String[] args) {
        SpringApplication.run(DbServiceApplication.class, args);
    }
}
