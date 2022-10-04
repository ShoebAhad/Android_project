package com.app.hotel.viewModels;

public class User {
    private String name, sex, contact_no, mail;

    public User() {

    }

    public User(String name, String sex, String contact_no, String mail) {
        this.name = name;
        this.sex = sex;
        this.contact_no = contact_no;
        this.mail = mail;
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
}
