package com.perpule.singletons;

import com.perpule.constants.DBConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {
    private static DBConnectionSingleton  dbConnectionSingleton = null;
    private Connection connection;

    public DBConnectionSingleton() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DBConstant.getDBURL(),DBConstant.getDBUsername(),DBConstant.getDBPassword());
    }
    public Connection getConnection(){
        return connection;
    }

    public static DBConnectionSingleton getInstance() throws SQLException, ClassNotFoundException {
        if (dbConnectionSingleton == null){
            return new DBConnectionSingleton();
        }else{
            return dbConnectionSingleton;
        }
    }

}
