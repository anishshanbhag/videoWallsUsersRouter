package com.perpule.productService;

public class ProductCreateRequestModel {
  private String productName;
  private String productDetails;
  private String productCategory;

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
