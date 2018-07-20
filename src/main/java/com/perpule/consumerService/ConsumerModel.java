package com.perpule.consumerService;

public class ConsumerModel {
  private String id;
  private String name;
  private String phoneNumber;
  private int createdAt;
  private String deviceId;
  private String productId;
  private String productName;

  public ConsumerModel() {}

  public ConsumerModel(String id, String name, String phoneNumber, int createdAt, String deviceId,String productId,String productName) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.createdAt = createdAt;
    this.deviceId = deviceId;
    this.productId = productId;
    this.productName = productName;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(int createdAt) {
    this.createdAt = createdAt;
  }

  public String getProductId(){
    return productId;
  }

  public void setProductId(String productId){
    this.productId = productId;
  }

  public String getProductName(){
    return productName;
  }

  public void setProductName(String productName){
    this.productName = productName;
  }
}
