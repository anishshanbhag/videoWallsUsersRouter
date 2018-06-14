package com.perpule.servlets.api;

import com.google.gson.Gson;
import com.perpule.constants.ResponseCodeConstant;
import com.perpule.models.ResponseModel;
import com.perpule.salesmanService.SalesmanDAO;
import com.perpule.salesmanService.SalesmanSignInSignUpRequestModel;
import jdk.nashorn.internal.runtime.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("salesman")
public class SalesmanResource {
    private SalesmanDAO salesmanDAO = new SalesmanDAO();
    @Path("createSalesman")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel createSalesman(SalesmanSignInSignUpRequestModel salesmanSignInSignUpRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG),null);
        responseModel.setData(new Gson().toJson(salesmanDAO.createSalesman(salesmanSignInSignUpRequestModel)));
        responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
        return responseModel;
    }
    @Path("checkSalesmanUserNameExist")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel checkSalesmanUserNameExist(SalesmanSignInSignUpRequestModel salesmanSignInSignUpRequestModel) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG),null);
        if (salesmanDAO.isSalesmanUsernameExists(salesmanSignInSignUpRequestModel.getUserName())){
            org.apache.log4j.Logger.getLogger(getClass()).info("true username exist");
        }else{
            org.apache.log4j.Logger.getLogger(getClass()).info("false username doesn't exist");
        }
        return responseModel;
    }
}
