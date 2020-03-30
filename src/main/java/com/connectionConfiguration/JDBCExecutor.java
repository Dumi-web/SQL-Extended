package com.connectionConfiguration;

import org.postgresql.util.PSQLException;

import java.sql.*;


public class JDBCExecutor {
    public static void main(String[] args) throws SQLException {
        databaseConnectionManager dcm = new databaseConnectionManager("localhost", "umuzi", "user", "pass");
        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i < columnCount; i++) {
                    String columnName = resultSetMetaData.getColumnName(i);
                    System.out.print(columnName.toUpperCase() + ": ");
                    System.out.print(resultSet.getString(i) + ", ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        try {
            Connection connections = dcm.getConnection();
            Statement statements = connections.createStatement();
            ResultSet resultSets = statements.executeQuery("SELECT * FROM customers");
            while (resultSets.next()) {
                System.out.println(resultSets.getString("first_name"));
            }
        } catch (PSQLException e) {
            e.printStackTrace();
        }
        System.out.println();
            try {
                Connection connections = dcm.getConnection();
                Statement statements = connections.createStatement();
                ResultSet resultSets = statements.executeQuery("select * FROM customers WHERE customersid = 1");
                while (resultSets.next()) {
                    System.out.println(resultSets.getString("first_name"));
                }
            } catch (PSQLException e) {
                e.printStackTrace();
            }
        System.out.println();
        try {
            Connection connections = dcm.getConnection();
            Statement statements = connections.createStatement();
            String psql = "DELETE FROM customers " + "WHERE customersid = 2";
            statements.executeUpdate(psql);
           psql = "SELECT customersid,first_name,last_name,gender,address,phone,email,city FROM customers";
           ResultSet rs = statements.executeQuery(psql);
           while(rs.next()){
               int id  = rs.getInt("customersid");
               String first = rs.getString("first_name");
               String last = rs.getString("last_name");
               String gender = rs.getString("gender");
               String address = rs.getString("address");
               String phone = rs.getString("phone");
               String email = rs.getString("email");
               String city = rs.getString("city");

               System.out.print("CUSTOMERSID: "+id);
               System.out.print(",FIRST_NAME: "+first);
               System.out.print(", LAST_NAME: "+last);
               System.out.print(", GENDER: "+gender);
               System.out.print(", ADDRESS: "+address);
               System.out.print(", PHONE: "+phone);
               System.out.print(", EMAIL: "+email);
               System.out.println(", CITY: "+city);
           }
        }catch (PSQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        try{
            Connection connections = dcm.getConnection();
            Statement statements = connections.createStatement();
            String psqls = "UPDATE customers " +
                    "SET first_name = 'Lerato',last_name = 'Mabitso' WHERE customersid = 1 ";
            statements.executeUpdate(psqls);
            psqls = "SELECT customersid,first_name,last_name,gender,address,phone,email,city FROM customers";
            ResultSet rq = statements.executeQuery(psqls);
            while(rq.next()){
                int id  = rq.getInt("customersid");
                String first = rq.getString("first_name");
                String last = rq.getString("last_name");
                String gender = rq.getString("gender");
                String address = rq.getString("address");
                String phone = rq.getString("phone");
                String email = rq.getString("email");
                String city = rq.getString("city");

                System.out.print("CUSTOMERSID: "+id);
                System.out.print(",FIRST_NAME: "+first);
                System.out.print(", LAST_NAME: "+last);
                System.out.print(", GENDER: "+gender);
                System.out.print(", ADDRESS: "+address);
                System.out.print(", PHONE: "+phone);
                System.out.print(", EMAIL: "+email);
                System.out.println(", CITY: "+city);
            }
        }catch (PSQLException z){
            z.printStackTrace();
        }
        System.out.println();
        try{
            Connection connections = dcm.getConnection();
            Statement statements = connections.createStatement();
            String psqlc = "SELECT DISTINCT on (status) status from orders";
            ResultSet rz = statements.executeQuery(psqlc);
            while(rz.next()) {
                String status = rz.getString("status");
                System.out.println("STATUS: " + status);
            }
        }catch (PSQLException b){
            b.printStackTrace();
        }
        System.out.println();
        try{
            Connection connections = dcm.getConnection();
            Statement statements = connections.createStatement();
            String psqlm = "SELECT MAX (amount) amount FROM payments";
            ResultSet rc = statements.executeQuery(psqlm);
            while(rc.next()) {
                double amount = rc.getDouble("amount");
                System.out.println("MAX AMOUNT: " + amount);
            }
        }catch (PSQLException b){
            b.printStackTrace();
        }
    }
}
