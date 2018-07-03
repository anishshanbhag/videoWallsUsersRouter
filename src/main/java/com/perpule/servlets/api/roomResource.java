package com.perpule.servlets.api;


import com.google.gson.Gson;
import com.perpule.constants.ResponseCodeConstant;
import com.perpule.models.ResponseModel;
import com.perpule.roomService.RoomDAO;
import com.perpule.roomService.RoomDatabaseModel;
import com.perpule.salesmanService.SalesmanDAO;
import com.perpule.salesmanService.SalesmanDatabaseModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("room")
public class roomResource {
    private RoomDAO roomDAO = new RoomDAO();
    private SalesmanDAO salesmanDAO = new SalesmanDAO();

    @POST
    @Path("createRoom")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public ResponseModel createRoom(RoomDatabaseModel roomDatabaseModel) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
        responseModel.setData(new Gson().toJson(roomDAO.createRoom(roomDatabaseModel)));
        responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
        return responseModel;
    }

    @POST
    @Path("getRoom")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public ResponseModel getRoom(SalesmanDatabaseModel salesmanDatabaseModel, @Context HttpHeaders httpheaders) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
        if (salesmanDAO.isAuthTokenExists(httpheaders.getHeaderString("authToken"))) {
            responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
            responseModel.setData(new Gson().toJson(roomDAO.getEmptyRequestedRoom(salesmanDatabaseModel.getId())));
        } else {
            responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_NOT_FOUND_OR_NOT_MATCHED));
        }
        return responseModel;

    }
}
