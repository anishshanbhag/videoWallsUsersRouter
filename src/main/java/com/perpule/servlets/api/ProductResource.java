package com.perpule.servlets.api;

import com.google.gson.Gson;
import com.perpule.constants.ResponseCodeConstant;
import com.perpule.models.ResponseModel;
import com.perpule.productService.ProductCreateRequestModel;
import com.perpule.productService.ProductDAO;
import com.perpule.salesmanService.SalesmanDAO;
import com.perpule.salesmanService.SalesmanSignInSignUpRequestModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("product")
public class ProductResource {

    private ProductDAO productDAO= new ProductDAO();

    @Path("createProduct")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel createProduct(ProductCreateRequestModel productCreateRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG),null);
            responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
            responseModel.setData(new Gson().toJson(productDAO.createProduct(productCreateRequestModel)));
        return responseModel;
    }

}
