package com.perpule;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.perpule.filter.CORSFilter;


public class JerseyApplication extends ResourceConfig {
  public JerseyApplication() {
    register(JacksonFeature.class);
    register(CORSFilter.class);
  }
}
