package com.price.db.dto;

import lombok.Data;

/**
 * @program: freework
 * @description: this is a 数据库信息
 * @author: Yeats
 * @create: 2019-06-03 14:20
 **/
@Data
public class DB {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    /**localhost:3306*/
    public static String url = "192.168.10.200:3306/electronic";
    public static String userName = "root";
    /**mysql*/
    public static String userPW = "123456";
    public static void setOfflineDB() {
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/global_3rd_db?useUnicode=true&serverTimezone=UTC&useSSL=false&autoReconnect=true&characterEncoding=utf-8";
        userName = "root";
        userPW = "mysql";
    }
    public static void setWxDB() {
        driver = "org.postgresql.Driver";
        url = "jdbc:postgresql://203.60.1.50:5432/globaldb_wx";
        userName = "globaladmin";
        userPW = "mysql";
    }
}
