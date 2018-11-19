package com.example.sriva.adbeta;

public class Upload {
    private String mName;
    private String mSize;
    private  String mPrice;
    private String mMaplink;
    private String mImageUrl;



    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String size, String price, String maplink, String imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mSize=size;
        mPrice=price;
        mMaplink=maplink;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
    public String getSize() {
        return mSize;
    }

    public void setSize(String size) {
        mSize=size;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }
    public String getMaplink() {
        return mMaplink;
    }

    public void setMaplink(String maplink) {
        mMaplink = maplink;
    }
    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
