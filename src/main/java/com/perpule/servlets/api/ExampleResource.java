package com.perpule.servlets.api;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;

@Path("example")
public class ExampleResource{
	
  @Path("{example}")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String example(@PathParam("example") String example) {
    Logger.getLogger(getClass()).info("Working???");
    return example + "!!!!";
  }
}
