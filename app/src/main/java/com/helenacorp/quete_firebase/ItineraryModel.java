package com.helenacorp.quete_firebase;

import java.util.Date;

/**
 * Created by helena on 03/07/2017.
 */

public class ItineraryModel {

    private int userID;
    private String driverLastName;
    private String driverFirstName;
    private Date departureDate;
    private int price;
    private String departure;
    private String destination;

    public ItineraryModel(int userID, String driverLastName, String driverFirstName,
                          Date departureDate, int price, String departure, String destination) {
        this.userID = userID;
        this.driverLastName = driverLastName;
        this.driverFirstName = driverFirstName;
        this.departureDate = departureDate;
        this.price = price;
        this.departure = departure;
        this.destination = destination;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
