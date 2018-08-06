package com.perpule.servlets.api;

import com.google.gson.Gson;
import com.perpule.constants.ResponseCodeConstant;
import com.perpule.models.ResponseModel;
import com.perpule.salesmanService.SalesmanDAO;
import com.perpule.salesmanService.SalesmanDatabaseModel;
import com.perpule.salesmanService.SalesmanSignInSignUpRequestModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ContainerResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("salesman")
public class SalesmanResource implements ContainerResponseFilter {
	private SalesmanDAO salesmanDAO = new SalesmanDAO();

	@Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		response.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, authToken");
		response.getHeaders().add("Access-Control-Allow-Credentials", "true");
		response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}

	@Path("createSalesman")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel createSalesman(SalesmanSignInSignUpRequestModel salesmanSignInSignUpRequestModel)
			throws SQLException, NoSuchAlgorithmException {
		ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
		if (salesmanDAO.isSalesmanUsernameExists(salesmanSignInSignUpRequestModel.getUserName())) {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.USERNAME_NOT_AVAILABLE));
		} else {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));

			responseModel.setData(new Gson().toJson(salesmanDAO.createSalesman(salesmanSignInSignUpRequestModel)));
		}
		return responseModel;
	}

	@Path("checkSalesmanUserNameExist")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel checkSalesmanUserNameExist(SalesmanSignInSignUpRequestModel salesmanSignInSignUpRequestModel)
			throws SQLException {
		ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
		if (salesmanDAO.isSalesmanUsernameExists(salesmanSignInSignUpRequestModel.getUserName())) {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.USERNAME_NOT_AVAILABLE));
		} else {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.USERNAME_AVAILABLE));
		}
		return responseModel;
	}

	@Path("checkSalesmanUser")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel checkSalesmanUser(SalesmanSignInSignUpRequestModel salesmanSignInSignUpRequestModel)
			throws SQLException, NoSuchAlgorithmException {
		ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
		if (salesmanDAO.isSalemanUserExists(salesmanSignInSignUpRequestModel)) {
			SalesmanDatabaseModel salesmanDatabaseModel = salesmanDAO
					.getSalemanUserData(salesmanSignInSignUpRequestModel);
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
			responseModel.setData(new Gson().toJson(salesmanDatabaseModel));
		} else {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.USERNAME_NOT_FOUND));
		}
		return responseModel;
	}

	@Path("checkAuthToken")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel checkAuthToken(@Context HttpHeaders httpheaders) throws SQLException {
		ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
		if (salesmanDAO.isAuthTokenExists(httpheaders.getHeaderString("authToken"))) {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_FOUND_OR_MATCHED));
		} else {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_NOT_FOUND_OR_NOT_MATCHED));
		}
		return responseModel;
	}

	@Path("setActive")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel setActive(@Context HttpHeaders httpheaders) throws SQLException {
		ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
		if (salesmanDAO.isAuthTokenExists(httpheaders.getHeaderString("authToken"))) {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_FOUND_OR_MATCHED));
			if (salesmanDAO.setActive(httpheaders.getHeaderString("authToken"))) {
				responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
			}
		} else {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_NOT_FOUND_OR_NOT_MATCHED));
		}
		return responseModel;
	}

	@Path("unSetActive")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel unsetActive(@Context HttpHeaders httpheaders) throws SQLException {
		ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
		if (salesmanDAO.isAuthTokenExists(httpheaders.getHeaderString("authToken"))) {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_FOUND_OR_MATCHED));
			if (salesmanDAO.unSetActive(httpheaders.getHeaderString("authToken"))) {
				responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
			}
		} else {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_NOT_FOUND_OR_NOT_MATCHED));
		}
		return responseModel;
	}

	@Path("setOccupied")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel setOccupied(@Context HttpHeaders httpheaders) throws SQLException {
		ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
		if (salesmanDAO.isAuthTokenExists(httpheaders.getHeaderString("authToken"))) {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_FOUND_OR_MATCHED));
			if (salesmanDAO.setOccupied(httpheaders.getHeaderString("authToken"))) {
				responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
			}
		} else {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_NOT_FOUND_OR_NOT_MATCHED));
		}
		return responseModel;
	}

	@Path("unSetOccupied")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel unsetOccupied(@Context HttpHeaders httpheaders) throws SQLException {
		ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
		if (salesmanDAO.isAuthTokenExists(httpheaders.getHeaderString("authToken"))) {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_FOUND_OR_MATCHED));
			if (salesmanDAO.unSetOccupied(httpheaders.getHeaderString("authToken"))) {
				responseModel.setResponse(String.valueOf(ResponseCodeConstant.EVERYTHING_IS_OK));
			}
		} else {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.AUTH_TOKEN_NOT_FOUND_OR_NOT_MATCHED));
		}
		return responseModel;
	}

	@Path("checkIfActive")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel checkIfActive(@Context HttpHeaders httpheaders) throws SQLException {
		ResponseModel responseModel = new ResponseModel(String.valueOf(ResponseCodeConstant.SOMETHING_IS_WRONG), null);
		if (salesmanDAO.isActive(httpheaders.getHeaderString("authToken"))) {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.SALESMAN_IS_ACTIVE));
		} else {
			responseModel.setResponse(String.valueOf(ResponseCodeConstant.SALESMAN_IS_NOT_ACTIVE));
		}
		return responseModel;
	}
}
