package com.exalt.transportationbookingsystem.models.trip.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;

@AerospikeRecord(namespace="test", set="flight")
public class FlightDB extends TripDB {

    private String flightClass;

    @AerospikeReference
    private PlaneDB plane;


    //getters & setters
    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public PlaneDB getPlane() {
        return plane;
    }

    public void setPlane(PlaneDB plane) {
        this.plane = plane;
    }

    //constructor

    public FlightDB(int id, String date, int seatNo, String departureTime, String arrivalTime,
        String startLocation, String destination,
        UserDB user, String flightClass,
        PlaneDB plane) {
        super(id, date, seatNo, departureTime, arrivalTime, startLocation, destination, user);
        this.flightClass = flightClass;
        this.plane = plane;
    }
}
