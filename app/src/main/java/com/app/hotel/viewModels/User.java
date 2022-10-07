package com.app.hotel.viewModels;

public class User {
    private String fname, lname, mobile, mailId;

    public User() {

    }

    public User(String fname, String lname, String mobile, String mailId) {
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.mailId = mailId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
}