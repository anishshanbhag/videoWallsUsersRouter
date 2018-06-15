package com.perpule.productService;

public class ProductDatabaseModel {
    private String id;
    private String productName;
    private String productDetails;
    private String productCategory;

    public ProductDatabaseModel(String id, String productName, String productDetails, String productCategory) {
        this.id = id;
        this.productName = productName;
        this.productDetails = productDetails;
        this.productCategory = productCategory;
    }

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
}
