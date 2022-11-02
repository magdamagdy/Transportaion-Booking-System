package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import com.exalt.transportationbookingsystem.dbconfiguration.database;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import java.util.List;

public class busDaoImpl implements BusDao {

  private final String license = "license";
  private final String manifacCountry = "manifacCountry";
  private final String model = "model";
  private final String colour = "colour";
  private final String noOfSeats ="noOfSeats";

  /**
   * The Aerospike Instance.
   */
  database aerospike = database.getInstance();

  @Override
  public void saveBus(BusDB bus){
      aerospike.mapper.save(bus);
  }

  @Override
  public void updateBus(BusDB bus){
      aerospike.mapper.update(bus,license, manifacCountry,model,colour,noOfSeats);
  }

  @Override
  public BusDB readBusById(int id){
    return aerospike.mapper.read(BusDB.class, id);
  }

  @Override
  public List<BusDB> readAllBuses(){
    return aerospike.mapper.scan(BusDB.class);
  }

  @Override
  public void deleteBusById(int id){
      aerospike.mapper.delete(BusDB.class, id);
  }

}
