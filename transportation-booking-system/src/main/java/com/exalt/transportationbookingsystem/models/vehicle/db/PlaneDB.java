package com.exalt.transportationbookingsystem.models.vehicle.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

@AerospikeRecord(namespace="test", set="plane")
public class PlaneDB extends VehicleDB {
    private String airport;
    private String airlines;


    //getters & setters
    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    //constructor
    public PlaneDB(int id, String license, String manifacCountry, String model, String colour,
        int noOfSeats, DriverDB driver,
        String airport, String airlines) {
        super(id, license, manifacCountry, model, colour, noOfSeats, driver);
        this.airport = airport;
        this.airlines = airlines;
    }
}
