package com.perpule.servlets.api;

import com.perpule.constants.ResponseCodeConstant;
import com.perpule.models.ResponseModel;
import com.perpule.salesmanService.SalesmanSignInSignUpRequestModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("salesman")
public class SalesmanResource {

    @Path("createSalesman")
    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel createSalesman(SalesmanSignInSignUpRequestModel salesmanSignInSignUpRequestModel){
        ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG),null);

        return responseModel;
    }
}
