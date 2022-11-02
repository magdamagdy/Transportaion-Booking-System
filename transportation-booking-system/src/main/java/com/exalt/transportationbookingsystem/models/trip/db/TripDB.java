package com.exalt.transportationbookingsystem.models.trip.db;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;

/**
 * The type Trip db.
 */
@AerospikeRecord(namespace="test")
public class TripDB {

    /**
     * The Id.
     */
    @AerospikeKey
    protected int id;
    /**
     * The Date.
     */
    protected String date;
    /**
     * The Seat no.
     */
    protected int seatNo;
    /**
     * The Departure time.
     */
    protected String departureTime;
    /**
     * The Arrival time.
     */
    protected String arrivalTime;
    /**
     * The Start location.
     */
    protected String startLocation;
    /**
     * The Destination.
     */
    protected String destination;

    /**
     * The User.
     */
    @AerospikeReference
    protected UserDB user;


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets departure time.
     *
     * @return the departure time
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets departure time.
     *
     * @param departureTime the departure time
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Gets arrival time.
     *
     * @return the arrival time
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets arrival time.
     *
     * @param arrivalTime the arrival time
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets start location.
     *
     * @return the start location
     */
    public String getStartLocation() {
        return startLocation;
    }

    /**
     * Sets start location.
     *
     * @param startLocation the start location
     */
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Gets destination.
     *
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets destination.
     *
     * @param destination the destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public UserDB getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(UserDB user) {
        this.user = user;
    }

    /**
     * Gets seat no.
     *
     * @return the seat no
     */
    public int getSeatNo() {
        return seatNo;
    }

    /**
     * Sets seat no.
     *
     * @param seatNo the seat no
     */
    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    /**
     * Instantiates a new Trip db.
     *
     * @param id            the id
     * @param date          the date
     * @param seatNo        the seat no
     * @param departureTime the departure time
     * @param arrivalTime   the arrival time
     * @param startLocation the start location
     * @param destination   the destination
     * @param user          the user
     */
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
