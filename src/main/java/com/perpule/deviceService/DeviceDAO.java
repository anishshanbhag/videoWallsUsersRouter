package com.perpule.deviceService;

import com.perpule.singletons.DBManager;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class DeviceDAO {

  public DeviceResponseDatabaseModel createDevice(
      DeviceResponseDatabaseModel deviceResponseDatabaseModel)
      throws SQLException, NoSuchAlgorithmException {
    String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
    deviceResponseDatabaseModel.setCreatedAt(createdAt);
    String id =
        RandomAndHashStringUtil.getId(
            deviceResponseDatabaseModel.getDeviceFingerprint(), createdAt);
    deviceResponseDatabaseModel.setId(id);
    String salesmanId = deviceResponseDatabaseModel.getSalesmanId();
    String deviceFingerprint = deviceResponseDatabaseModel.getDeviceFingerprint();
    boolean isVerified = true;
    String sqlQuery =
        "INSERT INTO device (id , deviceFingerprint , isVerified , createdAt , salesmanId) VALUES ( '"
            + id
            + "' , '"
            + deviceFingerprint
            + "' , "
            + isVerified
            + " , '"
            + createdAt
            + "' , '"
            + salesmanId
            + "')";
    if (DBManager.doQuery(sqlQuery)) {
      return deviceResponseDatabaseModel;
    } else {
      throw new Error("doQuery function not working!");
    }
  }

  public boolean deleteDevice(String id)
      throws SQLException {
    String sqlQuery = "DELETE FROM device WHERE id = '" + id + "'";
    if (DBManager.doQuery(sqlQuery)) {
      return true;
    } else {
      throw new Error("doQuery function not working!");
    }
  }
}
