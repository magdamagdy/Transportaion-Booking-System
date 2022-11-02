package com.exalt.transportationbookingsystem.models.vehicle.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

/**
 * The type Bus db.
 */
@AerospikeRecord(namespace="test", set="bus")
public class BusDB extends VehicleDB {

  /**
   * Instantiates a new Bus db.
   *
   * @param id             the id
   * @param license        the license
   * @param manifacCountry the manufacturing country
   * @param model          the model
   * @param colour         the colour
   * @param noOfSeats      the no of seats
   * @param driver         the driver
   */
  public BusDB(int id, String license, String manifacCountry, String model, String colour,
      int noOfSeats, DriverDB driver) {
    super(id, license, manifacCountry, model, colour, noOfSeats, driver);
  }
}
