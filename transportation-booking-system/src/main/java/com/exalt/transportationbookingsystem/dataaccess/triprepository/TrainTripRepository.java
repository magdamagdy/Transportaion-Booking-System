package com.exalt.transportationbookingsystem.dataaccess.triprepository;

import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import java.util.List;

/**
 * The interface Train trip dao.
 */
public interface TrainTripRepository {

  /**
   * Save train trip.
   *
   * @param trip the trip
   */
  void saveTrainTrip(TrainTripDB trip);

  /**
   * Update train trip.
   *
   * @param trip the trip
   */
  void updateTrainTrip(TrainTripDB trip);

  /**
   * Read train trip by id train trip db.
   *
   * @param id the id
   * @return the train trip db
   */
  TrainTripDB readTrainTripById(int id);

  /**
   * Read all train trips list.
   *
   * @return the list of all TrainTrips
   */
  List<TrainTripDB> readAllTrainTrips();

  /**
   * Delete train trip by id.
   *
   * @param id the id
   */
  void deleteTrainTripById(int id);
}
