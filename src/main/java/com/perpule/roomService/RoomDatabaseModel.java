package com.perpule.roomService;

public class RoomDatabaseModel {
    private String id;
    private String consumerId;
    private String deviceId;
    private int requestedTime;
    private int startTime;
    private int averageWaitingTime;
    private int endTime;
    private String salesmanId;

    public RoomDatabaseModel() {
    }

    public RoomDatabaseModel(String id, String consumerId, String deviceId, int requestedTime, int startTime, int averageWaitingTime, int endTime, String salesmanId) {
        this.id = id;
        this.consumerId = consumerId;
        this.deviceId = deviceId;
        this.requestedTime = requestedTime;
        this.startTime = startTime;
        this.averageWaitingTime = averageWaitingTime;
        this.endTime = endTime;
        this.salesmanId = salesmanId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(int requestedTime) {
        this.requestedTime = requestedTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getAverageWaitingTime() {
        return averageWaitingTime;
    }

    public void setAverageWaitingTime(int averageWaitingTime) {
        this.averageWaitingTime = averageWaitingTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
    }


}
