package com.exalt.transportationbookingsystem.dataaccess.vehiclerepository;

import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import java.util.List;

/**
 * The interface Train dao.
 */
public interface TrainRepository {

  /**
   * Save train.
   *
   * @param train the train
   */
  void saveTrain(TrainDB train);

  /**
   * Update train.
   *
   * @param train the train
   */
  void updateTrain(TrainDB train);

  /**
   * Read train by id train db.
   *
   * @param id the id
   * @return the train db
   */
  TrainDB readTrainById(int id);

  /**
   * Read all trains list.
   *
   * @return the list of all Trains
   */
  List<TrainDB> readAllTrains();

  /**
   * Delete train by id.
   *
   * @param id the id
   */
  void deleteTrainById(int id);
}
