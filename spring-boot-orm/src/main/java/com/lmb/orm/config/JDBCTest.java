//package com.lmb.orm.config;
//
//import com.lmb.orm.entity.User;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// * Copyright (C), 2021,
// * FileName: JDBCTest
// * Author:   mubiao0205@gmail.com
// * Date:     2021/3/15 下午11:44
// * Description: TODO
// * Version:1.0.0
// */
//public class JDBCTest {
//
//    public static void main(String[] args) {
//        Connection connection = null;
//        PreparedStatement preparedStatement =null;
//        ResultSet resultSet = null;
//        try {
//            //1.加载数据库驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //2.通过驱动获取数据库链接
//            connection = DriverManager.getConnection("jdbc:mysql://211.159.184.140:3306/demo?characterEncoding=utf-8", "root", "li19930205");
//            //3.获取预处理statement
//            preparedStatement = connection.prepareStatement("select * from user where id =?");
//            //4.执行SQL
//            preparedStatement.setInt(1, 1);
//            resultSet = preparedStatement.executeQuery();
//            User user = new User();
//            while (resultSet.next()){
//                int id = resultSet.getl("id");
//                String username = resultSet.getString("userName");
//                user.setId(id);
//                user.setName(username);
//            }
//            System.out.println(user);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            //5.释放资源
//            if (resultSet!=null){
//                try {
//                    resultSet.close();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                } }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//}