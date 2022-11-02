package com.exalt.transportationbookingsystem.models.trip.db;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;

@AerospikeRecord(namespace="test")
public class TripDB {

    @AerospikeKey
    protected int id;
    protected String date;
    protected int seatNo;
    protected String departureTime;
    protected String arrivalTime;
    protected String startLocation;
    protected String destination;

    @AerospikeReference
    protected UserDB user;


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

    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    //constructor

    public TripDB(int id, String date, int seatNo, String departureTime, String arrivalTime,
        String startLocation, String destination, UserDB user) {
        this.id = id;
        this.date = date;
        this.seatNo = seatNo;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.startLocation = startLocation;
        this.destination = destination;
        this.user = user;
    }
}
