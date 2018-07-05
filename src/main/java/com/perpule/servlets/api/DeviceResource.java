package com.perpule.servlets.api;

import com.google.gson.Gson;
import com.perpule.constants.ResponseCodeConstant;
import com.perpule.deviceService.DeviceDAO;
import com.perpule.deviceService.DeviceResponseDatabaseModel;
import com.perpule.models.ResponseModel;
import com.perpule.salesmanService.SalesmanDAO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("device")
public class DeviceResource {
  private DeviceDAO deviceDAO = new DeviceDAO();
  private SalesmanDAO salesmanDAO = new SalesmanDAO();

  @Path("registerDevice")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseModel registerNewDevice(DeviceResponseDatabaseModel deviceResponseDatabaseModel)
      throws NoSuchAlgorithmException, SQLException {
    ResponseModel responseModel =
        new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
    if (salesmanDAO.isSalesmanManager(deviceResponseDatabaseModel.getSalesmanId())) {
      responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
      responseModel.setData(new Gson().toJson(deviceDAO.createDevice(deviceResponseDatabaseModel)));
    } else {
      responseModel.setResponse(String.valueOf(ResponseCodeConstant.NOT_A_MANAGER));
    }
    return responseModel;
  }

  @Path("deleteDevice")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseModel deleteDevice(DeviceResponseDatabaseModel deviceResponseDatabaseModel)
      throws SQLException {
    ResponseModel responseModel =
        new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
    if (salesmanDAO.isSalesmanManager(deviceResponseDatabaseModel.getSalesmanId())) {
      responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
      responseModel.setData(
          new Gson().toJson(deviceDAO.deleteDevice(deviceResponseDatabaseModel.getId())));
    } else {
      responseModel.setResponse(String.valueOf(ResponseCodeConstant.NOT_A_MANAGER));
    }
    return responseModel;
  }
}
