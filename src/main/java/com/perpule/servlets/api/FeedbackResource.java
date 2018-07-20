package com.perpule.servlets.api;

import com.google.gson.Gson;
import com.perpule.constants.ResponseCodeConstant;
import com.perpule.feedback.FeedbackDAO;
import com.perpule.feedback.FeedbackModel;
import com.perpule.models.ResponseModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("feedback")
public class FeedbackResource {
  private FeedbackDAO feedbackDAO = new FeedbackDAO();

  @Path("giveFeedback")
  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces(MediaType.APPLICATION_JSON)
  public ResponseModel giveFeedback(FeedbackModel feedbackModel)
      throws NoSuchAlgorithmException, SQLException {
    ResponseModel responseModel =
        new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
    responseModel.setData(new Gson().toJson(feedbackDAO.giveFeedback(feedbackModel)));
    responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
    return responseModel;
  }
}
