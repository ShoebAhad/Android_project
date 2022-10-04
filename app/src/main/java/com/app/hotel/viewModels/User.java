package com.app.hotel.viewModels;

public class User {
    private String name, sex, contact_no, mail, address, division;

    public User() {

    }

    public User(String name, String sex, String contact_no, String mail, String address, String division) {
        this.name = name;
        this.sex = sex;
        this.contact_no = contact_no;
        this.mail = mail;
        this.address = address;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
