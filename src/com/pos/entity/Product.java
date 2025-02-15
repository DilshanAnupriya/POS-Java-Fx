package com.pos.entity;

import java.util.Arrays;

public class Product implements SuperEntity{
    private String productId;
    private String productName;
    private Double productUnitPrice;
    private int productQty;
    private byte[] productQr;
    private byte[] productImg;

    public Product() {
    }

    public Product(String productId, String productName, Double productUnitPrice, int productQty, byte[] productQr, byte[] productImg) {
        this.productId = productId;
        this.productName = productName;
        this.productUnitPrice = productUnitPrice;
        this.productQty = productQty;
        this.productQr = productQr;
        this.productImg = productImg;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(Double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public byte[] getProductQr() {
        return productQr;
    }

    public void setProductQr(byte[] productQr) {
        this.productQr = productQr;
    }

    public byte[] getProductImg() {
        return productImg;
    }

    public void setProductImg(byte[] productImg) {
        this.productImg = productImg;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productUnitPrice='" + productUnitPrice + '\'' +
                ", productQty=" + productQty +
                ", productQr=" + Arrays.toString(productQr) +
                ", productImg=" + Arrays.toString(productImg) +
                '}';
    }
}
