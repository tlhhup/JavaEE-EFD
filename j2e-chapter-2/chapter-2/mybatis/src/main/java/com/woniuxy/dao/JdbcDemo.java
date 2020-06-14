package com.woniuxy.dao;

import com.woniuxy.entity.User;

import java.sql.*;

/**
 * Created by 离歌笑tlh/hu ping on 2019/3/25
 * <p>
 * Github: https://github.com/tlhhup
 */
public class JdbcDemo {

    public User findUserById(int id) {
        String url = "";
        String user = "";
        String password = "";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库链接
            connection = DriverManager.getConnection(url, user, password);
            //3.创建statement对象
            String sql = "select * from user where id=?";
            statement = connection.prepareStatement(sql);
            //4.执行语句
            resultSet = statement.executeQuery();
            //5.处理结果集
            resultSet.next();
            User userInfo = new User();
            userInfo.setId(resultSet.getInt("id"));
            userInfo.setName(resultSet.getString("name"));
            userInfo.setAddress(resultSet.getString("address"));
            userInfo.setAge(resultSet.getInt("age"));

            return userInfo;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet!=null){
                    resultSet.close();
                }
                if(statement!=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
