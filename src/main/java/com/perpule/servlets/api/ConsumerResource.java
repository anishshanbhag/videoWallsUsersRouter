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
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("consumer")
public class ConsumerResource {
  private ConsumerDAO consumerDAO = new ConsumerDAO();

  @Path("createConsumer")
  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces(MediaType.APPLICATION_JSON)
  public ResponseModel createConsumer(ConsumerModel consumerModel)
      throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
    ResponseModel responseModel =
        new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
    responseModel.setData(new Gson().toJson(consumerDAO.createConsumer(consumerModel)));
    responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
    return responseModel;
  }
}
