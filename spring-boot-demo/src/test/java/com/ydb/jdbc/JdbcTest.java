package com.ydb.jdbc;

import java.sql.*;

/**
 * @Author ligeng
 * @Date 18/11/29
 * @Time 下午3:56
 */
public class JdbcTest {
    public static void main(String[] args) {
        Driver myDriver = null;
        try {
            myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver( myDriver );
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study-test", "root", "wasd");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sys_data limit 5");

            while (resultSet.next()){
                System.out.println(resultSet.getString("id"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
