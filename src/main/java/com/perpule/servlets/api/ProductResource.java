package com.perpule.servlets.api;

import com.google.gson.Gson;
import com.perpule.constants.ResponseCodeConstant;
import com.perpule.models.ResponseModel;
import com.perpule.productService.ProductCreateRequestModel;
import com.perpule.productService.ProductDAO;
import com.perpule.productService.SearchProductRequestModel;
import com.perpule.salesmanService.SalesmanDAO;
import com.perpule.salesmanService.SalesmanSignInSignUpRequestModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("product")
public class ProductResource {

    private ProductDAO productDAO = new ProductDAO();
    private SalesmanDAO salesmanDAO = new SalesmanDAO();


    @Path("createProduct")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel createProduct(ProductCreateRequestModel productCreateRequestModel, @Context HttpHeaders httpheaders) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
        if (salesmanDAO.isAuthTokenExists(httpheaders.getHeaderString("authToken"))) {
            responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
            responseModel.setData(new Gson().toJson(productDAO.createProduct(productCreateRequestModel)));
        } else {
            responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_NOT_FOUND_OR_NOT_MATCHED));
        }
        return responseModel;
    }

    @Path("searchProduct")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel searchProduct(SearchProductRequestModel searchProductRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
        responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
        responseModel.setData(new Gson().toJson(productDAO.getSearchedProduct(searchProductRequestModel.getQueryString())));
        return responseModel;
    }

}
