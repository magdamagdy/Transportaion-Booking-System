package com.exalt.transportationbookingsystem.models.vehicle.dto;

import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;

/**
 * The type Vehicle dto.
 */
public class VehicleDTO {

    /**
     * The Id.
     */
    protected int id;
    /**
     * The License.
     */
    protected String license;
    /**
     * The Manifac country.
     */
    protected String manifacCountry;
    /**
     * The Model.
     */
    protected String model;
    /**
     * The Colour.
     */
    protected String colour;
    /**
     * The No of seats.
     */
    protected int noOfSeats;
    /**
     * The Ref driver id.
     */
    protected Integer refDriverId;
    /**
     * The Ref driver.
     */
    protected DriverDTO refDriver;


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
     * Gets license.
     *
     * @return the license
     */
    public String getLicense() {
        return license;
    }

    /**
     * Sets license.
     *
     * @param license the license
     */
    public void setLicense(String license) {
        this.license = license;
    }


    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets colour.
     *
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets colour.
     *
     * @param colour the colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Gets ref driver id.
     *
     * @return the ref driver id
     */
    public Integer getRefDriverId() {
        return refDriverId;
    }

    /**
     * Sets ref driver id.
     *
     * @param refDriverId the ref driver id
     */
    public void setRefDriverId(Integer refDriverId) {
        this.refDriverId = refDriverId;
    }

    /**
     * Gets ref driver.
     *
     * @return the ref driver
     */
    public DriverDTO getRefDriver() {
        return refDriver;
    }

    /**
     * Sets ref driver.
     *
     * @param refDriver the ref driver
     */
    public void setRefDriver(DriverDTO refDriver) {
        this.refDriver = refDriver;
    }

    /**
     * Gets manifac country.
     *
     * @return the manifac country
     */
    public String getManifacCountry() {
        return manifacCountry;
    }

    /**
     * Sets manifac country.
     *
     * @param manifacCountry the manifac country
     */
    public void setManifacCountry(String manifacCountry) {
        this.manifacCountry = manifacCountry;
    }

    /**
     * Gets no of seats.
     *
     * @return the no of seats
     */
    public int getNoOfSeats() {
        return noOfSeats;
    }

    /**
     * Sets no of seats.
     *
     * @param noOfSeats the no of seats
     */
    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}
