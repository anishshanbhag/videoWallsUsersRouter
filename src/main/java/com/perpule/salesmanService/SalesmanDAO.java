package com.perpule.salesmanService;

import com.perpule.singletons.DBConnectionSingleton;
import com.perpule.utils.RandomAndHashStringUtil;

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

    public boolean isSalemanUserExists(SalesmanSignInSignUpRequestModel salesmanSignInSignUpRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String sqlQuery = "SELECT * FROM salesman WHERE userName = '"+salesmanSignInSignUpRequestModel.getUserName()+"'";
        ResultSet resultSet = getResultset(sqlQuery);
        if (resultSet.isBeforeFirst()){
            resultSet.next();
            return resultSet.getString("hashedPassword").equals(RandomAndHashStringUtil.hashPassword(salesmanSignInSignUpRequestModel.getPassword(), resultSet.getString("randomString")));
        }else{
            return false;
        }
    }

    public SalesmanDatabaseModel getSalemanUserData(SalesmanSignInSignUpRequestModel salesmanSignInSignUpRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String sqlQuery = "SELECT * FROM salesman WHERE userName = '"+salesmanSignInSignUpRequestModel.getUserName()+"'";
        String id = null;
        String userName = null;
        String randomString = null;
        String hashedPassword = null;
        String role = null;
        boolean isActive = false;
        boolean isOccupied = false;
        String createdAt = null;
        String lastSignedIn = null;
        String authToken = null;
        ResultSet resultSet = getResultset(sqlQuery);
        if (resultSet.isBeforeFirst()) {
            resultSet.next();
            id = resultSet.getString("id");
            userName = resultSet.getString("userName");
            randomString = resultSet.getString("randomString");
            hashedPassword = resultSet.getString("hashedPassword");
            role = resultSet.getString("role");
            isActive = resultSet.getBoolean("isActive");
            isOccupied = resultSet.getBoolean("isOccupied");
            createdAt = resultSet.getString("createdAt");
            lastSignedIn = resultSet.getString("lastSignedIn");
            authToken = resultSet.getString("authToken");
        }
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
        return salesmanDatabaseModel;
    }

    public boolean isSalesmanUsernameExists(String userName) throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT * FROM salesman WHERE userName = '"+userName+"'";
        return getResultset(sqlQuery).isBeforeFirst();
    }

    public boolean isSalesmanManager(String salesmanId) throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT * FROM salesman WHERE id = '"+salesmanId+"' AND role = 'manager'";
        return getResultset(sqlQuery).isBeforeFirst();
    }

    public boolean isAuthTokenExists(String authToken) throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT * FROM salesman WHERE authToken = '"+authToken+"'";
        return getResultset(sqlQuery).isBeforeFirst();
    }

    public boolean setActive(String authToken) throws SQLException, ClassNotFoundException {
        String sqlQuery = "UPDATE salesman SET isActive = "+true+" WHERE authToken = '"+authToken+"'";
        return doQuery(sqlQuery);
    }

    public boolean unSetActive(String authToken) throws SQLException, ClassNotFoundException {
        String sqlQuery = "UPDATE salesman SET isActive = "+false+" WHERE authToken = '"+authToken+"'";
        return doQuery(sqlQuery);
    }
    public boolean setOccupied(String authToken) throws SQLException, ClassNotFoundException {
        String sqlQuery = "UPDATE salesman SET isOccupied = "+true+" WHERE authToken = '"+authToken+"'";
        return doQuery(sqlQuery);
    }

  public boolean unSetOccupied(String authToken) throws SQLException, ClassNotFoundException {
        String sqlQuery = "UPDATE salesman SET isOccupied = "+false+" WHERE authToken = '"+authToken+"'";
        return doQuery(sqlQuery);
    }

}
