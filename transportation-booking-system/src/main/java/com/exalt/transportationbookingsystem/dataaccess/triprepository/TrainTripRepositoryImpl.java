package com.exalt.transportationbookingsystem.dataaccess.triprepository;

import com.exalt.transportationbookingsystem.dbconfiguration.Database;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import java.util.List;

public class TrainTripRepositoryImpl implements TrainTripRepository {

  private final String date = "date";
  private final String seatNo ="seatNo";
  private final String trainClass ="trainClass";

  /**
   * The Aerospike Instance.
   */
  Database aerospike = Database.getInstance();

  @Override
  public void saveTrainTrip(TrainTripDB trip){
      aerospike.mapper.save(trip);
  }

  @Override
  public void updateTrainTrip(TrainTripDB trip){
      aerospike.mapper.update(trip,date, seatNo,trainClass);
  }

  @Override
  public TrainTripDB readTrainTripById(int id){
    return aerospike.mapper.read(TrainTripDB.class, id);
  }

  @Override
  public List<TrainTripDB> readAllTrainTrips(){
    return aerospike.mapper.scan(TrainTripDB.class);
  }

  @Override
  public void deleteTrainTripById(int id){
      aerospike.mapper.delete(TrainTripDB.class, id);
  }


}
