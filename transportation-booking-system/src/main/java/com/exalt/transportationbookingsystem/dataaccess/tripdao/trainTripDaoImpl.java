package com.exalt.transportationbookingsystem.dataaccess.tripdao;

import com.exalt.transportationbookingsystem.dbconfiguration.database;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import java.util.List;

public class trainTripDaoImpl implements TrainTripDao{

  private final String date = "date";
  private final String seatNo ="seatNo";
  private final String trainClass ="trainClass";
  database aerospike = database.getInstance();

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
