package com.example.digeat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
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

    protected User(Parcel in) {
        userId = in.readInt();
        userType = in.readInt();
        userWallet = in.readInt();
        userName = in.readString();
        userPass = in.readString();
        userEmail = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeInt(userType);
        parcel.writeInt(userWallet);
        parcel.writeString(userName);
        parcel.writeString(userPass);
        parcel.writeString(userEmail);
    }
}
