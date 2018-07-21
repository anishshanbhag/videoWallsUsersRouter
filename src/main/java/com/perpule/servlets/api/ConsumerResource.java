package com.perpule.servlets.api;

import com.google.gson.Gson;
import com.perpule.constants.ResponseCodeConstant;
import com.perpule.consumerService.ConsumerDAO;
import com.perpule.consumerService.ConsumerModel;
import com.perpule.models.ResponseModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("consumer")
public class ConsumerResource implements ContainerResponseFilter{
  private ConsumerDAO consumerDAO = new ConsumerDAO();
  
  @Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		response.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		response.getHeaders().add("Access-Control-Allow-Credentials", "true");
		response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}


  @Path("createConsumer")
  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces(MediaType.APPLICATION_JSON)
  public ResponseModel createConsumer(ConsumerModel consumerModel)
      throws NoSuchAlgorithmException, SQLException {
    ResponseModel responseModel =
        new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
    responseModel.setData(new Gson().toJson(consumerDAO.createConsumer(consumerModel)));
    responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
    return responseModel;
  }
}
