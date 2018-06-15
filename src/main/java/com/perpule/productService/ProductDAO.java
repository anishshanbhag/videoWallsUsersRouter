package com.perpule.productService;

import com.perpule.salesmanService.SalesmanDatabaseModel;
import com.perpule.salesmanService.SalesmanSignInSignUpRequestModel;
import com.perpule.singletons.DBConnectionSingleton;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO {
    private boolean doQuery(String sqlQuery) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnectionSingleton.getInstance().getConnection().prepareStatement(sqlQuery);
        preparedStatement.executeUpdate();
        return true;
    }

    private ResultSet getResultset(String sqlQuery) throws SQLException, ClassNotFoundException {
        Statement statement = DBConnectionSingleton.getInstance().getConnection().createStatement();
        return statement.executeQuery(sqlQuery);
    }


    public ProductDatabaseModel createProduct(ProductCreateRequestModel productCreateRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
        String id = RandomAndHashStringUtil.getId(productCreateRequestModel.getProductName(), createdAt);
        String productName = productCreateRequestModel.getProductName();
        String productDetails = productCreateRequestModel.getProductDetails();
        String productCategory = productCreateRequestModel.getProductCategory();
        ProductDatabaseModel productDatabaseModel = new ProductDatabaseModel(
                id,
                productName,
                productDetails,
                productCategory
        );
        String sqlQuery = "INSERT INTO product (id , productName , productDetails , productCategory) VALUES ( '"+id+"' , '"+productName+"' , '"+productDetails+"' , '"+productCategory+"' )";
        if (doQuery(sqlQuery)){
            return productDatabaseModel;
        }else{
            throw new Error("doQuery function not working!");
        }
    }
}
