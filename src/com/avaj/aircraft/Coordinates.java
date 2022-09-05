package com.avaj.aircraft;

public class Coordinates {
    private Integer longitude;
    private Integer latitude;
    private Integer height;

    Coordinates(Integer longitude, Integer latitude, Integer height){
        this.longitude = longitude;
        this.latitude = latitude;
        if (height > 100)
            this.height = 100;
        else
            this.height = height;
    }
    public Integer getLongitude() {
        return longitude;
    }
    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }
    public Integer getLatitude() {
        return latitude;
    }
    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        if (height > 100)
            height = 100;
        if (height < 0)
            height = 0;
        this.height = height;
    }
}
