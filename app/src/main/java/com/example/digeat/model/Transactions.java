package com.example.digeat.model;

public class Transactions {
    Integer transactionId, customerId, totalPrice;
    String transactionDate;

    public Transactions(Integer transactionId, Integer customerId, Integer totalPrice, String transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.transactionDate = transactionDate;
    }

    public Transactions(Integer customerId, Integer totalPrice, String transactionDate) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.transactionDate = transactionDate;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
