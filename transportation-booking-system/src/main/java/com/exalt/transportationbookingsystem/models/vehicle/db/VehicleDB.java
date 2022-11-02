package com.exalt.transportationbookingsystem.models.vehicle.db;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

@AerospikeRecord(namespace="test")
public class VehicleDB {

    @AerospikeKey
    protected int id;
    protected String license;
    protected String manifacCountry;
    protected String model;
    protected String colour;
    protected int noOfSeats;

    @AerospikeReference
    protected DriverDB driver;



    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getManifacCountry() {
        return manifacCountry;
    }

    public void setManifacCountry(String manifacCountry) {
        this.manifacCountry = manifacCountry;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public DriverDB getDriver() {
        return driver;
    }

    public void setDriver(DriverDB driver) {
        this.driver = driver;
    }

    //constructor


    public VehicleDB(int id, String license, String manifacCountry, String model, String colour,
        int noOfSeats, DriverDB driver) {
        this.id = id;
        this.license = license;
        this.manifacCountry = manifacCountry;
        this.model = model;
        this.colour = colour;
        this.noOfSeats = noOfSeats;
        this.driver = driver;
    }
}
