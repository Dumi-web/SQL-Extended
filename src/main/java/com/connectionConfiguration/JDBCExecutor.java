package com.connectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {
    public static void main(String[] args) {
        databaseConnectionManager dcm = new databaseConnectionManager("localhost","umuzi","postgres","pass");
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT (*) FROM customers");
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
