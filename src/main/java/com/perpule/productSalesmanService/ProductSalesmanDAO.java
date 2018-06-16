package com.perpule.productSalesmanService;

import com.perpule.singletons.DBConnectionSingleton;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductSalesmanDAO {

    private boolean doQuery(String sqlQuery) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnectionSingleton.getInstance().getConnection().prepareStatement(sqlQuery);
        preparedStatement.executeUpdate();
        return true;
    }

    private ResultSet getResultset(String sqlQuery) throws SQLException, ClassNotFoundException {
        Statement statement = DBConnectionSingleton.getInstance().getConnection().createStatement();
        return statement.executeQuery(sqlQuery);
    }

    public boolean createSalesmanProduct(ProductSalesmanDatabaseRequestModel productSalesmanDatabaseRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String sqlQuery = "INSERT INTO productSalesman (salesmanId , productId ) VALUES ( '"+productSalesmanDatabaseRequestModel.getSalesmanId()+"' , '"+productSalesmanDatabaseRequestModel.getProductId()+"' )";
        if (doQuery(sqlQuery)){
            return true;
        }else{
            throw new Error("doQuery function not working!");
        }
    }
}
