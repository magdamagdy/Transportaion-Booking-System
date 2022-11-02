package com.exalt.transportationbookingsystem.models.trip.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;

@AerospikeRecord(namespace="test", set="busTrip")
public class BusTripDB extends TripDB {

    @AerospikeReference
    private BusDB bus;


    //setter & getter
    public BusDB getBus() {
        return bus;
    }

    public void setBus(BusDB bus) {
        this.bus = bus;
    }

    //constructor

    public BusTripDB(int id, String date, int seatNo, String departureTime, String arrivalTime,
        String startLocation, String destination,
        UserDB user, BusDB bus) {
        super(id, date, seatNo, departureTime, arrivalTime, startLocation, destination, user);
        this.bus = bus;
    }
}
