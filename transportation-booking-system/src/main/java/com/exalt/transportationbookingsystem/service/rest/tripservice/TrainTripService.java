package com.exalt.transportationbookingsystem.service.rest.tripservice;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;

/**
 * The interface Train trip service.
 */
public interface TrainTripService {

  /**
   * Add train trip train trip dto.
   *
   * @param trainTrip the train trip
   * @return the train trip dto
   * @throws NullValueException    the null value exception
   * @throws AlreadyExistException the already exist exception
   */
  TrainTripDTO addTrainTrip(TrainTripDTO trainTrip) throws NullValueException, AlreadyExistException;

  /**
   * Update train trip train trip dto.
   *
   * @param trainTrip the train trip
   * @return the train trip dto
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  TrainTripDTO updateTrainTrip(TrainTripDTO trainTrip) throws NullValueException, NotFoundException;

}
