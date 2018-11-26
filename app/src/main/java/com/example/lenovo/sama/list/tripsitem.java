package com.example.lenovo.sama.list;

public class tripsitem {
    String countryName, tripcode, history, price, flightHours, arrivalHours, flightMin, arrivalMin;
    int buttonColor, LinearColor;
    int tripId, cityId;


    public tripsitem(int tripId, int cityId, String countryName, String tripcode, String history, String price, String flightHours, String arrivalHours, String flightMin, String arrivalMin) {
        this.countryName = countryName;
        this.tripcode = tripcode;
        this.history = history;
        this.price = price;
        this.flightHours = flightHours;
        this.arrivalHours = arrivalHours;
        this.tripId = tripId;
        this.cityId = cityId;
        this.flightMin = flightMin;
        this.arrivalMin = arrivalMin;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTripcode() {
        return tripcode;
    }

    public void setTripcode(String tripcode) {
        this.tripcode = tripcode;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(String flightHours) {
        this.flightHours = flightHours;
    }

    public String getArrivalHours() {
        return arrivalHours;
    }

    public void setArrivalHours(String arrivalHours) {
        this.arrivalHours = arrivalHours;
    }

    public String getFlightMin() {
        return flightMin;
    }

    public void setFlightMin(String flightMin) {
        this.flightMin = flightMin;
    }

    public String getArrivalMin() {
        return arrivalMin;
    }

    public void setArrivalMin(String arrivalMin) {
        this.arrivalMin = arrivalMin;
    }

    public int getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(int buttonColor) {
        this.buttonColor = buttonColor;
    }

    public int getLinearColor() {
        return LinearColor;
    }

    public void setLinearColor(int linearColor) {
        LinearColor = linearColor;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
