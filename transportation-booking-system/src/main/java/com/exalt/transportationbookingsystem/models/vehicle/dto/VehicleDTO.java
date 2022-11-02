package com.exalt.transportationbookingsystem.models.vehicle.dto;

import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;

public class VehicleDTO {

    protected int id;
    protected String license;
    protected String manifacCountry;
    protected String model;
    protected String colour;
    protected int noOfSeats;
    protected Integer refDriverId;

    protected DriverDTO refDriver;

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


    public Integer getRefDriverId() {
        return refDriverId;
    }

    public void setRefDriverId(Integer refDriverId) {
        this.refDriverId = refDriverId;
    }

    public DriverDTO getRefDriver() {
        return refDriver;
    }

    public void setRefDriver(DriverDTO refDriver) {
        this.refDriver = refDriver;
    }

    public String getManifacCountry() {
        return manifacCountry;
    }

    public void setManifacCountry(String manifacCountry) {
        this.manifacCountry = manifacCountry;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}
