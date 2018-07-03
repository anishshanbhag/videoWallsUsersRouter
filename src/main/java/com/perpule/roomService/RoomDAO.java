package com.perpule.roomService;

import com.perpule.singletons.DBConnectionSingleton;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomDAO {

    private boolean doQuery(String sqlQuery) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnectionSingleton.getInstance().getConnection().prepareStatement(sqlQuery);
        preparedStatement.executeUpdate();
        return true;
    }

    private ResultSet getResultset(String sqlQuery) throws SQLException, ClassNotFoundException {
        Statement statement = DBConnectionSingleton.getInstance().getConnection().createStatement();
        return statement.executeQuery(sqlQuery);
    }

    public RoomDatabaseModel createRoom(RoomDatabaseModel roomDatabaseModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
        String requestedTime = createdAt;
        roomDatabaseModel.setRequestedTime(Integer.parseInt(requestedTime));
        String deviceId = roomDatabaseModel.getDeviceId();
        String id = RandomAndHashStringUtil.getId(deviceId, createdAt);
        String averageWaitingTime = String.valueOf(getAverageWaitingTime());
        roomDatabaseModel.setId(id);
        roomDatabaseModel.setAverageWaitingTime(Integer.parseInt(averageWaitingTime));
        String sqlQuery = "INSERT INTO `room` (`id`, `consumerId`, `deviceId`, `requestedTime`, `startTime`, `averageWaitingTime`, `endTime`, `salesmanId`) VALUES ( '" + id + "' , NULL , '" + deviceId + "' , '" + requestedTime + "' , NULL , '" + averageWaitingTime + "', NULL , NULL )";
        if (doQuery(sqlQuery)) {
            return roomDatabaseModel;
        } else {
            throw new Error("doQuery function not working!");
        }
    }

    public int getAverageWaitingTime() throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT AVG(`waitingTime`) AS `averageWaitingTime` FROM (SELECT `startTime` - `requestedTime` AS `waitingTime` FROM `room`) AS waitingTimeTable";
        ResultSet resultSet = getResultset(sqlQuery);
        if (resultSet.isBeforeFirst()) {
            resultSet.next();
            return resultSet.getInt("averageWaitingTime");
        } else {
            return 60;
        }
    }

    public RoomDatabaseModel getEmptyRequestedRoom(String salesmanId) throws SQLException, ClassNotFoundException {
        RoomDatabaseModel roomDatabaseModel = new RoomDatabaseModel();
        String sqlQuery = "SELECT * FROM `room` WHERE salesmanId IS NULL";
        ResultSet resultSet = getResultset(sqlQuery);
        if (resultSet.isBeforeFirst()) {
            resultSet.next();
            sqlQuery = "UPDATE `salesman` SET isOccupied = TRUE WHERE id = '" + salesmanId + "'";
            String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
            if (doQuery(sqlQuery)) {
                sqlQuery = "UPDATE `room` SET salesmanId = '" + salesmanId + "' , startTime = " + createdAt + " WHERE id = '" + resultSet.getString("id") + "'";
                if (doQuery(sqlQuery)) {
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
}
