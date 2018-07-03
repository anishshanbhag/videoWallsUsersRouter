package com.perpule.consumerService;

import com.perpule.singletons.DBConnectionSingleton;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsumerDAO {
  private boolean doQuery(String sqlQuery) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
        DBConnectionSingleton.getInstance().getConnection().prepareStatement(sqlQuery);
    preparedStatement.executeUpdate();
    return true;
  }

  private ResultSet getResultset(String sqlQuery) throws SQLException, ClassNotFoundException {
    Statement statement = DBConnectionSingleton.getInstance().getConnection().createStatement();
    return statement.executeQuery(sqlQuery);
  }

  public ConsumerModel createConsumer(ConsumerModel consumerModel)
      throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
    String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
    String id = RandomAndHashStringUtil.getId(consumerModel.getDeviceId(), createdAt);
    String name = consumerModel.getName();
    String phoneNumber = consumerModel.getPhoneNumber();
    String deviceId = consumerModel.getDeviceId();
    String sqlQuery =
        "INSERT INTO consumer (id , name , phoneNumber, createdAt, deviceId ) VALUES ( '"
            + id
            + "' , '"
            + name
            + "' , "
            + phoneNumber
            + " , "
            + createdAt
            + " , '"
            + deviceId
            + "')";
    if (doQuery(sqlQuery)) {
      return consumerModel;
    } else {
      throw new Error("doQuery function not working!");
    }
  }
}
