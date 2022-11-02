package com.exalt.transportationbookingsystem.models.vehicle.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

@AerospikeRecord(namespace="test", set="bus")
public class BusDB extends VehicleDB {

  //constructor

  public BusDB(int id, String license, String manifacCountry, String model, String colour,
      int noOfSeats, DriverDB driver) {
    super(id, license, manifacCountry, model, colour, noOfSeats, driver);
  }
}
