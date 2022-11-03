package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;

/**
 * The interface Train service.
 */
public interface TrainService {

  /**
   * Add train train dto.
   *
   * @param train the train
   * @return the train dto
   * @throws NullValueException the null value exception
   */
  TrainDTO addTrain(TrainDTO train) throws NullValueException;

  /**
   * Update train train dto.
   *
   * @param train the train
   * @return the train dto
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  TrainDTO updateTrain(TrainDTO train) throws NullValueException, NotFoundException;

}
