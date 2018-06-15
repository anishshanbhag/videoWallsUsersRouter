package com.perpule.productService;

public class ProductDatabaseModel {
    private String id;
    private String productName;
    private String productDetails;
    private String productCategory;
    private String productStringTags;
    private float totalRatings;
    private int totalUsersRated;
    private int totalHits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductStringTags() {
        return productStringTags;
    }

    public void setProductStringTags(String productStringTags) {
        this.productStringTags = productStringTags;
    }

    public float getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(float totalRatings) {
        this.totalRatings = totalRatings;
    }

    public int getTotalUsersRated() {
        return totalUsersRated;
    }

    public void setTotalUsersRated(int totalUsersRated) {
        this.totalUsersRated = totalUsersRated;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public ProductDatabaseModel(String id, String productName, String productDetails, String productCategory, String productStringTags, float totalRatings, int totalUsersRated, int totalHits) {
        this.id = id;
        this.productName = productName;
        this.productDetails = productDetails;
        this.productCategory = productCategory;
        this.productStringTags = productStringTags;
        this.totalRatings = totalRatings;
        this.totalUsersRated = totalUsersRated;
        this.totalHits = totalHits;
    }
}
