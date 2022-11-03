package com.exalt.transportationbookingsystem.dataaccess.triprepository;

import com.exalt.transportationbookingsystem.dbconfiguration.Database;
import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import java.util.List;

public class BusTripRepositoryImpl implements BusTripRepository {

  private final String date = "date";
  private final String seatNo ="seatNo";

  /**
   * The Aerospike Instance.
   */
  Database aerospike = Database.getInstance();

  @Override
  public void saveBusTrip(BusTripDB trip){
      aerospike.mapper.save(trip);
  }

  @Override
  public void updateBusTrip(BusTripDB trip){
      aerospike.mapper.update(trip,date, seatNo);
  }

  @Override
  public BusTripDB readBusTripById(int id){
    return aerospike.mapper.read(BusTripDB.class, id);
  }

  @Override
  public List<BusTripDB> readAllBusTrips(){
    return aerospike.mapper.scan(BusTripDB.class);
  }

  @Override
  public void deleteBusTripById(int id){
      aerospike.mapper.delete(BusTripDB.class, id);
  }


}
