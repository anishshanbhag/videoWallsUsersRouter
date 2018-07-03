package com.perpule.productService;

import com.perpule.singletons.DBConnectionSingleton;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {
  private boolean doQuery(String sqlQuery) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
        DBConnectionSingleton.getInstance().getConnection().prepareStatement(sqlQuery);
    preparedStatement.executeUpdate();
    return true;
  }

  private ResultSet getResultset(String sqlQuery) throws SQLException, ClassNotFoundException {
    Statement statement = DBConnectionSingleton.getInstance().getConnection().createStatement();
    return statement.executeQuery(sqlQuery);
  }

  public ProductDatabaseModel createProduct(ProductCreateRequestModel productCreateRequestModel)
      throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
    String createdAt = String.valueOf(System.currentTimeMillis() / 1000L);
    String id =
        RandomAndHashStringUtil.getId(productCreateRequestModel.getProductName(), createdAt);
    String productName = productCreateRequestModel.getProductName();
    String productDetails = productCreateRequestModel.getProductDetails();
    String productCategory = productCreateRequestModel.getProductCategory();
    String productStringTags =
        RandomAndHashStringUtil.getProductStringTags(
            productName + " " + productDetails + " " + productCategory);
    int totalRatings = 0;
    int totalUsersRated = 0;
    int totalHits = 0;
    ProductDatabaseModel productDatabaseModel =
        new ProductDatabaseModel(
            id,
            productName,
            productDetails,
            productCategory,
            productStringTags,
            totalRatings,
            totalUsersRated,
            totalHits);
    String sqlQuery =
        "INSERT INTO product (id , productName , productDetails , productCategory , productStringTags , totalRatings , totalUsersRated , totalHits) VALUES ( '"
            + id
            + "' , '"
            + productName
            + "' , '"
            + productDetails
            + "' , '"
            + productCategory
            + "' , '"
            + productStringTags
            + "' , "
            + totalRatings
            + " , "
            + totalUsersRated
            + " , "
            + totalHits
            + ")";
    if (doQuery(sqlQuery)) {
      return productDatabaseModel;
    } else {
      throw new Error("doQuery function not working!");
    }
  }

  public ArrayList<ProductDatabaseModel> getSearchedProduct(String queryString)
      throws SQLException, ClassNotFoundException {
    String sqlQuery =
        "SELECT * FROM product WHERE productStringTags LIKE '%" + queryString + "%' LIMIT 100";
    ArrayList<ProductDatabaseModel> list = new ArrayList<>();
    ResultSet resultSet = getResultset(sqlQuery);
    while (resultSet.next()) {
      String id = resultSet.getString("id");
      String productName = resultSet.getString("productName");
      String productDetails = resultSet.getString("productDetails");
      String productCategory = resultSet.getString("productCategory");
      String productStringTags = resultSet.getString("productStringTags");
      int totalRatings = resultSet.getInt("totalRatings");
      int totalUsersRated = resultSet.getInt("totalUsersRated");
      int totalHits = resultSet.getInt("totalHits");
      ProductDatabaseModel productDatabaseModel =
          new ProductDatabaseModel(
              id,
              productName,
              productDetails,
              productCategory,
              productStringTags,
              totalRatings,
              totalUsersRated,
              totalHits);
      list.add(productDatabaseModel);
    }
    return list;
  }
}
