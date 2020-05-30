package com.hy.readDb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Yong
 * @Date: 2020/5/28 18:31
 * @Version 1.0
 * @PACKAGE_NAME : com.hy.readDb
 **/
public class DBUtil {
    //1、执行静态方法,加载数据库驱动
    static {
        try {
            System.out.println("正在加载数据库驱动...");
            System.out.println("Class.forName('oracle.jdbc.driver.OracleDriver');");

            //这边参数的意义，url:jdbc数据库网址 user:用户名（String类型） password:密码（String类型）
            // [这边的数据库密码和用户名填写自己的]。
            // 同样由于getConnection方法会抛出SQLException，要使用try-catch
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("已加载数据库驱动！！！\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //2、创建数据库连接的方法
    public Connection getConnection() {
        Connection connection;
        try {
            System.out.println("正在连接到数据库...");
            System.out.println("connection = DriverManager.getConnection('jdbc:oracle:thin:@10.101.13.12:1521/orcl', 'icm', 'icm');");

            ///这边参数的意义，url:jdbc数据库网址 user:用户名 password:密码。
            // 同样由于getConnection方法会抛出SQLException，要使用try-catch
            connection =
                    //DriverManager.getConnection("jdbc:oracle:thin:@172.16.18.29:1521/orcl",
                    DriverManager.getConnection("jdbc:oracle:thin:@10.101.13.12:1521/orcl",
                            "icm",
                            "icm");

            System.out.println("已连接到icm数据库！！！\n");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //3、关闭数据库连接，释放JDBC资源的方法
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                System.out.println("准备释放jdbc资源，断开数据库连接...");
                System.out.println("connection.close();");
                connection.close();//立即释放jdbc资源，而不是等自动释放
                System.out.println("已断开数据库连接并且释放了jdbc资源\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
