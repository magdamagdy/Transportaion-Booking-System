package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import java.util.List;

public interface TrainDao {
  void saveTrain(TrainDB train);
  void updateTrain(TrainDB train);
  TrainDB readTrainById(int id);
  List<TrainDB> readAllTrains();
  void deleteTrainById(int id);
}
