package com.perpule.singletons;

import com.perpule.constants.DBConstant;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {
  private static DBConnectionSingleton dbConnectionSingleton = null;
  private Connection connection;

  public DBConnectionSingleton() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connection =
        DriverManager.getConnection(
            DBConstant.getDBURL(), DBConstant.getDBUsername(), DBConstant.getDBPassword());
  }

  public static DBConnectionSingleton getInstance() throws SQLException, ClassNotFoundException {
    if (dbConnectionSingleton == null) {
      Logger.getLogger("joeydash").info("dbConnection newly created and given");

      return new DBConnectionSingleton();

    } else {
      Logger.getLogger("joeydash").info("dbConnection old given");
      return dbConnectionSingleton;
    }
  }

  public Connection getConnection() {
    return connection;
  }
}
