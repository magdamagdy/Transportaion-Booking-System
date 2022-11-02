package com.exalt.transportationbookingsystem.models.vehicle.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

@AerospikeRecord(namespace="test", set="train")
public class TrainDB extends VehicleDB {
    private String railwayStation;

    //getters & setters
    public String getRailwayStation() {
        return railwayStation;
    }

    public void setRailwayStation(String railwayStation) {
        this.railwayStation = railwayStation;
    }

    //constructor

    public TrainDB(int id, String license, String manifacCountry, String model, String colour,
        int noOfSeats, DriverDB driver,
        String railwayStation) {
        super(id, license, manifacCountry, model, colour, noOfSeats, driver);
        this.railwayStation = railwayStation;
    }
}
