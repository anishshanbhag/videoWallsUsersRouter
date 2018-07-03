package com.perpule.salesmanService;

public class SalesmanDatabaseModel {

    public static final String SALESMAN_ROLE = "salesman";
    public static final String MANAGER_ROLE = "manager";

    private String id;
    private String userName;
    private String randomString;
    private String hashedPassword;
    private String role;
    private boolean isActive;
    private boolean isOccupied;
    private String createdAt;
    private String lastSignedIn;
    private String authToken;

    public SalesmanDatabaseModel() {
    }

    public SalesmanDatabaseModel(String id, String userName, String randomString, String hashedPassword, String role, boolean isActive, boolean isOccupied, String createdAt, String lastSignedIn, String authToken) {
        this.id = id;
        this.userName = userName;
        this.randomString = randomString;
        this.hashedPassword = hashedPassword;
        this.role = role;
        this.isActive = isActive;
        this.isOccupied = isOccupied;
        this.createdAt = createdAt;
        this.lastSignedIn = lastSignedIn;
        this.authToken = authToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastSignedIn() {
        return lastSignedIn;
    }

    public void setLastSignedIn(String lastSignedIn) {
        this.lastSignedIn = lastSignedIn;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
