package com.exalt.transportationbookingsystem.dataaccess.tripdao;

import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import java.util.List;

public interface TrainTripDao {
  void saveTrainTrip(TrainTripDB trip);
  void updateTrainTrip(TrainTripDB trip);
  TrainTripDB readTrainTripById(int id);
  List<TrainTripDB> readAllTrainTrips();
  void deleteTrainTripById(int id);
}
