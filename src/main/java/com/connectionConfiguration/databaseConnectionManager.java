package com.connectionConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class databaseConnectionManager {
    private final String url;
    private final Properties properties;

    public databaseConnectionManager(String host,String databaseName,String userName,String password){
        this.url = "jdbc:postgresql://"+host+"/"+databaseName;
        this.properties = new Properties();
        this.properties.setProperty("postgres",userName);
        this.properties.setProperty("pass",password);
    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(this.url,"postgres","pass");
    }
}
