package com.example.report.penjualan.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Long transactionId;

    @Column (name = "productId", nullable = false)
    private Long productId;

    @Column (name = "customerId", nullable = false)
    private Long customerId;

    @Column (name = "transactionDate")
    private Date transactionDate;

    @Column (name = "quantity")
    private int quantity;

    @Column (name = "margin")
    private double margin;

    @Column (name = "shippingCost")
    private double shippingCost = 10000;

    @Column (name = "tax")
    private double tax;

    @Column (name = "totalAmount")
    private double totalAmount;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double calculateTotalAmount(Product product) {
        double price = product.getPrice();
        double marginAmount = price * this.margin;
        double taxAmount = (price + marginAmount) * 0.10;
        this.totalAmount = price + marginAmount + this.shippingCost + taxAmount;
        return this.totalAmount;
    }
}
