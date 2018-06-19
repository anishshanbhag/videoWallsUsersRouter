package com.perpule.deviceService;

import com.perpule.singletons.DBConnectionSingleton;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class DeviceDAO {


    private boolean doQuery(String sqlQuery) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnectionSingleton.getInstance().getConnection().prepareStatement(sqlQuery);
        preparedStatement.executeUpdate();
        return true;
    }

    private ResultSet getResultset(String sqlQuery) throws SQLException, ClassNotFoundException {
        Statement statement = DBConnectionSingleton.getInstance().getConnection().createStatement();
        return statement.executeQuery(sqlQuery);
    }

    public DeviceResponseDatabaseModel createDevice(DeviceResponseDatabaseModel deviceResponseDatabaseModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
        deviceResponseDatabaseModel.setCreatedAt(createdAt);
        String id = RandomAndHashStringUtil.getId(deviceResponseDatabaseModel.getDeviceFingerprint(),createdAt);
        deviceResponseDatabaseModel.setId(id);
        String salesmanId  = deviceResponseDatabaseModel.getSalesmanId();
        String deviceFingerprint = deviceResponseDatabaseModel.getDeviceFingerprint();
        boolean isVerified  = true;
        String sqlQuery = "INSERT INTO device (id , deviceFingerprint , isVerified , createdAt , salesmanId) VALUES ( '"+id+"' , '"+deviceFingerprint+"' , "+isVerified+" , '"+createdAt+"' , '"+salesmanId+"')";
        if (doQuery(sqlQuery)){
            return deviceResponseDatabaseModel;
        }else{
            throw new Error("doQuery function not working!");
        }
    }

    public boolean deleteDevice(String id) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String sqlQuery = "DELETE FROM device WHERE id = '"+id+"'";
        if (doQuery(sqlQuery)){
            return true;
        }else{
            throw new Error("doQuery function not working!");
        }
    }
}
