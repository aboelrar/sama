package com.example.lenovo.sama;

public class tasneefitem {
    String name;
    int image;
    String details;

    public tasneefitem(String name, int image, String details) {
        this.name = name;
        this.image = image;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
