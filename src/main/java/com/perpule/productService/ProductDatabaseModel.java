package com.perpule.productService;

public class ProductDatabaseModel {
  private String id;
  private String productName;
  private String productDetails;
  private String productCategory;
  private String productStringTags;
  private int productMRP ;
  private int productSellingPrice;

  public ProductDatabaseModel() {}

  public ProductDatabaseModel(
      String id,
      String productName,
      String productDetails,
      String productCategory,
      String productStringTags,
      int productMRP,
      int productSellingPrice
      ) {
    this.id = id;
    this.productName = productName;
    this.productDetails = productDetails;
    this.productCategory = productCategory;
    this.productStringTags = productStringTags;
    this.productMRP = productMRP;
    this.productSellingPrice = productSellingPrice;
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

  public String getProductStringTags() {
    return productStringTags;
  }

  public void setProductStringTags(String productStringTags) {
    this.productStringTags = productStringTags;
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
