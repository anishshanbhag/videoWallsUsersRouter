// package com.perpule.productSalesmanService;
//
// import com.perpule.productService.ProductDatabaseModel;
// import com.perpule.singletons.DBManager;
// import com.perpule.utils.RandomAndHashStringUtil;
// import org.apache.log4j.Logger;
//
// import java.security.NoSuchAlgorithmException;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
//
// public class ProductSalesmanDAO {
//
//   public boolean createSalesmanProduct(
//       ProductSalesmanDatabaseRequestModel productSalesmanDatabaseRequestModel)
//       throws SQLException, NoSuchAlgorithmException {
//     String id =
//         RandomAndHashStringUtil.getId(
//             productSalesmanDatabaseRequestModel.getSalesmanId(),
//             productSalesmanDatabaseRequestModel.getProductId());
//     String sqlQuery =
//         "INSERT INTO productSalesman (id ,salesmanId , productId ) VALUES ( '"
//             + id
//             + "','"
//             + productSalesmanDatabaseRequestModel.getSalesmanId()
//             + "' , '"
//             + productSalesmanDatabaseRequestModel.getProductId()
//             + "' )";
//     if (DBManager.doQuery(sqlQuery)) {
//       return true;
//     } else {
//       throw new Error("doQuery function not working!");
//     }
//   }
//
//   public boolean removeSalesmanProduct(
//       ProductSalesmanDatabaseRequestModel productSalesmanDatabaseRequestModel)
//       throws SQLException {
//     String sqlQuery =
//         "DELETE FROM productSalesman WHERE salesmanId = '"
//             + productSalesmanDatabaseRequestModel.getSalesmanId()
//             + "' AND productId = '"
//             + productSalesmanDatabaseRequestModel.getProductId()
//             + "'";
//     if (DBManager.doQuery(sqlQuery)) {
//       return true;
//     } else {
//       throw new Error("doQuery function not working!");
//     }
//   }
//
//   public ArrayList<ProductSalesmanDatabaseRequestModel> getAllProductSalesmanMapping(
//       ProductSalesmanDatabaseRequestModel productSalesmanDatabaseRequestModel)
//       throws SQLException {
//     ArrayList<ProductSalesmanDatabaseRequestModel> list = new ArrayList<>();
//
//     String sqlQuery =
//         "SELECT * FROM productSalesman WHERE salesmanId = '"
//             + productSalesmanDatabaseRequestModel.getSalesmanId()
//             + "'";
//     ResultSet resultSet = DBManager.getResultset(sqlQuery);
//     if (resultSet.isBeforeFirst()) {
//       while (resultSet.next()) {
//         ProductSalesmanDatabaseRequestModel productSalesmanDatabaseRequestModel1 =
//             new ProductSalesmanDatabaseRequestModel();
//         productSalesmanDatabaseRequestModel.setId(resultSet.getString("id"));
//         productSalesmanDatabaseRequestModel1.setSalesmanId(
//             productSalesmanDatabaseRequestModel.getSalesmanId());
//         productSalesmanDatabaseRequestModel1.setProductId(resultSet.getString("productId"));
//         list.add(productSalesmanDatabaseRequestModel1);
//       }
//       return list;
//     } else {
//       return list;
//     }
//   }
//
//   public ArrayList<ProductDatabaseModel> getAllProductsRegisteredByUser(
//       ArrayList<ProductSalesmanDatabaseRequestModel> list)
//       throws SQLException {
//     ArrayList<ProductDatabaseModel> list1 = new ArrayList<>();
//     StringBuilder sqlQuery = new StringBuilder("SELECT * FROM product WHERE id IN (");
//     for (int i = 0; i < list.size(); i++) {
//       sqlQuery.append("'").append(list.get(i).getProductId()).append("'");
//       if (i != list.size() - 1) {
//         sqlQuery.append(",");
//       }
//     }
//     sqlQuery.append(")");
//     Logger.getLogger(getClass()).info(sqlQuery);
//     ResultSet resultSet = DBManager.getResultset(sqlQuery.toString());
//     if (resultSet.isBeforeFirst()) {
//       while (resultSet.next()) {
//         ProductDatabaseModel productDatabaseModel =
//             new ProductDatabaseModel(
//                 resultSet.getString("id"),
//                 resultSet.getString("productName"),
//                 resultSet.getString("productDetails"),
//                 resultSet.getString("productCategory"),
//                 resultSet.getString("productStringTags"),
//                 resultSet.getFloat("totalRatings"),
//                 resultSet.getInt("totalUsersRated"),
//                 resultSet.getInt("totalHits"));
//         list1.add(productDatabaseModel);
//       }
//       return list1;
//     } else {
//       return list1;
//     }
//   }
// }
