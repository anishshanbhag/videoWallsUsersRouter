package com.perpule.salesmanService;

public class SalesmanSignInSignUpRequestModel {
  private String userName;
  private String password;

  public SalesmanSignInSignUpRequestModel() {
  }

  public SalesmanSignInSignUpRequestModel(String userName, String password) {

    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
