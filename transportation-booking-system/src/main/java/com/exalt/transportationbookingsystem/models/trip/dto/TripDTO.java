package com.exalt.transportationbookingsystem.models.trip.dto;

import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;

public class TripDTO {

    protected int id;

    protected String date;
    protected int seatNo;
    protected String departureTime;
    protected String arrivalTime;
    protected String startLocation;
    protected String destination;

    protected Integer refUserId;

    protected UserDTO refUser;

    //setters & getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getRefUserId() {
        return refUserId;
    }

    public void setRefUserId(Integer refUserId) {
        this.refUserId = refUserId;
    }

    public UserDTO getRefUser() {
        return refUser;
    }

    public void setRefUser(UserDTO refUser) {
        this.refUser = refUser;
    }
}
