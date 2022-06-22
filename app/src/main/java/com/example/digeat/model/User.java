package com.example.digeat.model;

public class User{
    Integer userId, userType, userWallet;
    String userName, userPass, userEmail;

    public User(Integer userType, Integer userWallet, String userName, String userPass, String userEmail) {
        this.userType = userType;
        this.userWallet = userWallet;
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
    }

    public User (){

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(Integer userWallet) {
        this.userWallet = userWallet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
