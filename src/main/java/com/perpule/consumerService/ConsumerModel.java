package com.perpule.consumerService;

public class ConsumerModel {
  private String id;
  private String name;
  private String phoneNumber;
  private int createdAt;
  private String deviceId;

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
}
