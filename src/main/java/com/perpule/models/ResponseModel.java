package com.perpule.models;

public class ResponseModel {

  private String response;
  private String data;

  public ResponseModel(String response, String data) {

    this.response = response;
    this.data = data;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
