package com.userinfo.userinfo.pojo;

public class UserInfo {
    int id;
    String username;
    int gender;
    String phonenumber;

    public UserInfo(String name, int gender, String phonenumber) {
        this.username=name;
        this.gender = gender;
        this.phonenumber = phonenumber;
    }

    public UserInfo() {}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public int getGender() {
        return gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
