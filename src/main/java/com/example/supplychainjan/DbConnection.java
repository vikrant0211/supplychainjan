package com.example.supplychainjan;
//import com.sun.jdi.connect.Connector;


import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;


public class DbConnection {
    private static final String dbURL = "jdbc:mysql://localhost:3306/supplychaindec";
    private static final String userName = "root";
    private static final String password = "vikrant@2003";

    public Statement getStatement (){
        Statement statement = null;
        Connection conn;

        try {
            conn = DriverManager.getConnection(dbURL,userName,password);
            statement = conn.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return statement;
    }
    public ResultSet getQueryTable(String query){
        Statement statement = getStatement();
        try {
            return statement.executeQuery(query);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdateQuery(String query){
        Statement statement = getStatement();
        try {
            //return statement.executeUpdate(query);
            return statement.executeUpdate(query);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

//    public static void main(String[] args) {
//        DbConnection dbConnection = new DbConnection();
//        ResultSet rs = dbConnection.getQueryTable("SELECT Email, First_Name FROM customer");
//        try {
//            while(rs.next()){
//                System.out.println(rs.getString("email")+ " " + rs.getString("First_Name"));
//
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }

}
