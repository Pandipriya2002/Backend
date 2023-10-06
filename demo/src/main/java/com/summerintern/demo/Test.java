//package com.summerintern.demo;
//
//import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Test {
//    public static void main (String args[])
//    {
//
//        String url="jdbc:mysql://localhost:3306/test";
//        String user="root";
//        String password="Mahashri@2022";
//
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection= DriverManager.getConnection(url,user,password);
//            System.out.println("Connection is Successful to the database"+url);
//            String query="Insert into student(id,name)values(103,'diya')";
//                 Statement statement =connection.createStatement();
//            statement.execute (query);
//
//
//        }catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }catch(SQLException throwables ){
//            throwables.printStackTrace();
//        }
//
//    }
//}
//
