package com.perpule.salesmanService;

import com.perpule.singletons.DBConnectionSingleton;
import com.perpule.utils.RandomAndHashStringUtil;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesmanDAO {

    private boolean doQuery(String sqlQuery) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnectionSingleton.getInstance().getConnection().prepareStatement(sqlQuery);
        preparedStatement.executeUpdate();
        return true;
    }

    private ResultSet getResultset(String sqlQuery) throws SQLException, ClassNotFoundException {
        Statement statement = DBConnectionSingleton.getInstance().getConnection().createStatement();
        return statement.executeQuery(sqlQuery);
    }

    public SalesmanDatabaseModel createSalesman(SalesmanSignInSignUpRequestModel salesmanSignInSignUpRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
        String id = RandomAndHashStringUtil.getId(salesmanSignInSignUpRequestModel.getUserName(),createdAt);
        String userName = salesmanSignInSignUpRequestModel.getUserName();
        String randomString = RandomAndHashStringUtil.randomString(31);
        String hashedPassword = RandomAndHashStringUtil.hashPassword(salesmanSignInSignUpRequestModel.getPassword(),randomString);
        String role = SalesmanDatabaseModel.SALESMAN_ROLE;
        boolean isActive = false;
        boolean isOccupied = false;
        String lastSignedIn = createdAt;
        String authToken = RandomAndHashStringUtil.randomString(31);
        SalesmanDatabaseModel salesmanDatabaseModel = new SalesmanDatabaseModel(
                id,
                userName,
                randomString,
                hashedPassword,
                role,
                isActive,
                isOccupied,
                createdAt,
                lastSignedIn,
                authToken
        );

        String sqlQuery = "INSERT INTO salesman (id , userName , randomString , hashedPassword , role , isActive , isOccupied , createdAt , lastSignedIn , authToken ) VALUES ( '"+id+"' , '"+userName+"' , '"+randomString+"' , '"+hashedPassword+"' , '"+role+"' , "+isActive+" , "+ isOccupied + " , '"+createdAt+"' , '"+lastSignedIn+"' , '"+authToken+"' )";
        if (doQuery(sqlQuery)){
            return salesmanDatabaseModel;
        }else{
            throw new Error("doQuery function not working!");
        }
    }

    public boolean isSalesmanUsernameExists(String userName) throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT * FROM salesman WHERE userName = '"+userName+"'";
        if (!getResultset(sqlQuery).isBeforeFirst()){
            return false;
        }else {
            return true;
        }
    }
}
