package com.exalt.transportationbookingsystem.models.vehicle.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

/**
 * The type Train db.
 */
@AerospikeRecord(namespace="test", set="train")
public class TrainDB extends VehicleDB {
    private String railwayStation;

    /**
     * Gets railway station.
     *
     * @return the railway station
     */
    public String getRailwayStation() {
        return railwayStation;
    }

    public void setRailwayStation(String railwayStation) {
        this.railwayStation = railwayStation;
    }


    /**
     * Instantiates a new Train db.
     *
     * @param id             the id
     * @param license        the license
     * @param manifacCountry the manufacturing country
     * @param model          the model
     * @param colour         the colour
     * @param noOfSeats      the no of seats
     * @param driver         the driver
     * @param railwayStation the railway station
     */
    public TrainDB(int id, String license, String manifacCountry, String model, String colour,
        int noOfSeats, DriverDB driver,
        String railwayStation) {
        super(id, license, manifacCountry, model, colour, noOfSeats, driver);
        this.railwayStation = railwayStation;
    }
}
