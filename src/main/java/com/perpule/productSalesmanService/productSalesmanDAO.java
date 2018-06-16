package com.perpule.productSalesmanService;

import com.perpule.productService.ProductCreateRequestModel;
import com.perpule.productService.ProductDatabaseModel;
import com.perpule.singletons.DBConnectionSingleton;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class productSalesmanDAO {

    private boolean doQuery(String sqlQuery) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnectionSingleton.getInstance().getConnection().prepareStatement(sqlQuery);
        preparedStatement.executeUpdate();
        return true;
    }

    private ResultSet getResultset(String sqlQuery) throws SQLException, ClassNotFoundException {
        Statement statement = DBConnectionSingleton.getInstance().getConnection().createStatement();
        return statement.executeQuery(sqlQuery);
    }

    public ProductDatabaseModel createSalesmanProduct(ProductCreateRequestModel productCreateRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String sqlQuery = "INSERT INTO product (id , productName , productDetails , productCategory , productStringTags , totalRatings , totalUsersRated , totalHits) VALUES ( '"+id+"' , '"+productName+"' , '"+productDetails+"' , '"+productCategory+"' , '"+productStringTags+"' , "+totalRatings+" , "+totalUsersRated+" , "+totalHits+")";
        if (doQuery(sqlQuery)){
            return productCreateRequestModel;
        }else{
            throw new Error("doQuery function not working!");
        }
    }
}
