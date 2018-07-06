package com.perpule.consumerService;

import com.perpule.singletons.DBManager;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class ConsumerDAO {

  public ConsumerModel createConsumer(ConsumerModel consumerModel)
      throws SQLException, NoSuchAlgorithmException {
    String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
    String id = RandomAndHashStringUtil.getId(consumerModel.getDeviceId(), createdAt);
    consumerModel.setId(id);
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
    if (DBManager.doQuery(sqlQuery)) {
      return consumerModel;
    } else {
      throw new Error("doQuery function not working!");
    }
  }
}
