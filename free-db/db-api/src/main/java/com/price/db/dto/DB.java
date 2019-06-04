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
    private String driver="com.mysql.cj.jdbc.Driver";
    public static String url = "192.168.10.200:3306/electronic";//localhost:3306/
    public static String  userName= "root";
    public static String userPW = "123456";//mysql

    public static void setOfflineDB() {
        url = "localhost:3306/global_3rd_db";
        userName = "root";
        userPW = "mysql";//
    }
}
