package com.exalt.transportationbookingsystem.models.vehicle.db;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

/**
 * The type Vehicle db.
 */
@AerospikeRecord(namespace="test")
public class VehicleDB {

    /**
     * The Id.
     */
    @AerospikeKey
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
     * The Driver.
     */
    @AerospikeReference
    protected DriverDB driver;


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

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public DriverDB getDriver() {
        return driver;
    }

    /**
     * Sets driver.
     *
     * @param driver the driver
     */
    public void setDriver(DriverDB driver) {
        this.driver = driver;
    }


    /**
     * Instantiates a new Vehicle db.
     *
     * @param id             the id
     * @param license        the license
     * @param manifacCountry the manufacturing country
     * @param model          the model
     * @param colour         the colour
     * @param noOfSeats      the no of seats
     * @param driver         the driver
     */
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
