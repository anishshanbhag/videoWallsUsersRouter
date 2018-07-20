package com.perpule.productService;

public class ProductCreateRequestModel {
  private String productName;
  private String productDetails;
  private String productCategory;
  private int productMRP ;
  private int productSellingPrice;

  public ProductCreateRequestModel() {}

  public ProductCreateRequestModel(
      String productName, String productDetails, String productCategory,int productMRP ,int productSellingPrice) {
    this.productName = productName;
    this.productDetails = productDetails;
    this.productCategory = productCategory;
    this.productMRP = productMRP;
    this.productSellingPrice = productSellingPrice;
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
  public int getProductMRP() {
    return productMRP;
  }

  public void setProductMRP(int productMRP) {
    this.productMRP = productMRP;
  }

  public int getProductSellingPrice() {
    return productSellingPrice;
  }

  public void setProductSellingPrice(int productSellingPrice) {
    this.productSellingPrice = productSellingPrice;
  }
}
