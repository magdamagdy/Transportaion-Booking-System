package com.exalt.transportationbookingsystem.models.vehicle.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

/**
 * The type Plane db.
 */
@AerospikeRecord(namespace="test", set="plane")
public class PlaneDB extends VehicleDB {
    private String airport;
    private String airlines;


    /**
     * Gets airport.
     *
     * @return the airport
     */
    public String getAirport() {
        return airport;
    }

    /**
     * Sets airport.
     *
     * @param airport the airport
     */
    public void setAirport(String airport) {
        this.airport = airport;
    }

    /**
     * Gets airlines.
     *
     * @return the airlines
     */
    public String getAirlines() {
        return airlines;
    }

    /**
     * Sets airlines.
     *
     * @param airlines the airlines
     */
    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }


    /**
     * Instantiates a new Plane db.
     *
     * @param id             the id
     * @param license        the license
     * @param manifacCountry the manufacturing country
     * @param model          the model
     * @param colour         the colour
     * @param noOfSeats      the no of seats
     * @param driver         the driver
     * @param airport        the airport
     * @param airlines       the airlines
     */
    public PlaneDB(int id, String license, String manifacCountry, String model, String colour,
        int noOfSeats, DriverDB driver,
        String airport, String airlines) {
        super(id, license, manifacCountry, model, colour, noOfSeats, driver);
        this.airport = airport;
        this.airlines = airlines;
    }
}
