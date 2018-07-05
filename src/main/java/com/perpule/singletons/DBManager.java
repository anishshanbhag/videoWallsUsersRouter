package com.perpule.singletons;

import com.perpule.constants.DBConstant;

import java.sql.*;

public class DBManager {
  private static Connection connection;

  private static Connection getConnection() throws SQLException {
    if (connection == null) {
      connection =
          DriverManager.getConnection(
              DBConstant.getDBURL(), DBConstant.getDBUsername(), DBConstant.getDBPassword());
      return connection;
    } else {
      return connection;
    }
  }

  public static boolean doQuery(String sqlQuery) throws SQLException {
    PreparedStatement preparedStatement = getConnection().prepareStatement(sqlQuery);
    preparedStatement.executeUpdate();
    return true;
  }

  public static ResultSet getResultset(String sqlQuery) throws SQLException {
    Statement statement = getConnection().createStatement();
    return statement.executeQuery(sqlQuery);
  }

  public static int update(String sqlQuery) throws SQLException {
    Statement statement = getConnection().createStatement();
    return statement.executeUpdate(sqlQuery);
  }
}
