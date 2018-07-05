package com.perpule.roomService;

import com.perpule.singletons.DBManager;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDAO {

  public RoomDatabaseModel createRoom(RoomDatabaseModel roomDatabaseModel)
      throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
    String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
    String requestedTime = createdAt;
    roomDatabaseModel.setRequestedTime(Integer.parseInt(requestedTime));
    String deviceId = roomDatabaseModel.getDeviceId();
    String id = RandomAndHashStringUtil.getId(deviceId, createdAt);
    String averageWaitingTime = String.valueOf(getAverageWaitingTime());
    roomDatabaseModel.setId(id);
    roomDatabaseModel.setAverageWaitingTime(Integer.parseInt(averageWaitingTime));
    String sqlQuery =
        "INSERT INTO `room` (`id`, `consumerId`, `deviceId`, `requestedTime`, `startTime`, `averageWaitingTime`, `endTime`, `salesmanId`) VALUES ( '"
            + id
            + "' , NULL , '"
            + deviceId
            + "' , '"
            + requestedTime
            + "' , NULL , '"
            + averageWaitingTime
            + "', NULL , NULL )";
    if (DBManager.doQuery(sqlQuery)) {
      return roomDatabaseModel;
    } else {
      throw new Error("doQuery function not working!");
    }
  }

  public int getAverageWaitingTime() throws SQLException {
    String sqlQuery =
        "SELECT AVG(`waitingTime`) AS `averageWaitingTime` FROM (SELECT `startTime` - `requestedTime` AS `waitingTime` FROM `room`) AS waitingTimeTable";
    ResultSet resultSet = DBManager.getResultset(sqlQuery);
    if (resultSet.isBeforeFirst()) {
      resultSet.next();
      if (resultSet.getInt("averageWaitingTime") == 0) {
        return 10;
      } else {
        return resultSet.getInt("averageWaitingTime");
      }
    } else {
      return 10;
    }
  }

  public RoomDatabaseModel getEmptyRequestedRoom(String salesmanId) throws SQLException {
    RoomDatabaseModel roomDatabaseModel = new RoomDatabaseModel();
    String sqlQuery = "SELECT * FROM `room` WHERE salesmanId IS NULL";
    ResultSet resultSet = DBManager.getResultset(sqlQuery);
    if (resultSet.isBeforeFirst()) {
      resultSet.next();
      sqlQuery = "UPDATE `salesman` SET isOccupied = TRUE WHERE id = '" + salesmanId + "'";
      String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
      if (DBManager.doQuery(sqlQuery)) {
        sqlQuery =
            "UPDATE `room` SET salesmanId = '"
                + salesmanId
                + "' , startTime = "
                + createdAt
                + " WHERE id = '"
                + resultSet.getString("id")
                + "'";
        if (DBManager.doQuery(sqlQuery)) {
          roomDatabaseModel.setId(resultSet.getString("id"));
          return roomDatabaseModel;
        } else {
          return roomDatabaseModel;
        }
      } else {
        return roomDatabaseModel;
      }
    } else {
      return roomDatabaseModel;
    }
  }

  public boolean isSalesmanAllotted(String roomId) throws SQLException {
    String sqlQuery = "SELECT * FROM `room` WHERE salesmanId IS NOT NULL AND id = '" + roomId + "'";
    ResultSet resultSet = DBManager.getResultset(sqlQuery);
    return resultSet.isBeforeFirst();
  }

  public boolean deleteRoom(String roomId) throws SQLException {
    String sqlQuery = "DELETE FROM `room` WHERE salesmanId IS NULL AND id = '" + roomId + "'";
    return DBManager.update(sqlQuery) > 0;
  }
}
