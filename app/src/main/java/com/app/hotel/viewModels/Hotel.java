package com.app.hotel.viewModels;

public class Hotel {
    private String name, imageUrl, location;
    private String price;
    public Hotel() {
        //Empty Constructor
    }

    public Hotel(String name, String imageUrl, String price,  String location) {
        if(name=="") this.name = "name";
        else this.name = name;
        this.imageUrl = imageUrl;
        if(price=="") this.price="0";
        else this.price = price;
        if(location=="") this.location = "location";
        else this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
