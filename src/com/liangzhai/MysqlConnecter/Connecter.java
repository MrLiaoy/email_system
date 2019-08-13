package com.liangzhai.MysqlConnecter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: Email_System->Connecter
 * @description:
 * @author: lyl
 * @create: 2019-08-13 11:34
 **/
public class Connecter {

    //获取数据库连接
    public static Connection getConnection(){
        try {
            Properties properties =new Properties();
            properties.load(new FileInputStream("resource\\jdbcConfig.properties"));

            Class.forName(properties.getProperty("driver"));
            String url=properties.getProperty("url");
            String userName=properties.getProperty("username");
            String password=properties.getProperty("password");
            return DriverManager.getConnection(url,userName,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭数据库连接
    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
