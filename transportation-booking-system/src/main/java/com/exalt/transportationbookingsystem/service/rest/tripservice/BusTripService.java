package com.exalt.transportationbookingsystem.service.rest.tripservice;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;

/**
 * The interface Bus trip service.
 */
public interface BusTripService {

  /**
   * Add bus trip bus trip dto.
   *
   * @param busTrip the bus trip
   * @return the bus trip dto
   * @throws NullValueException    the null value exception
   * @throws AlreadyExistException the already exist exception
   */
  BusTripDTO addBusTrip(BusTripDTO busTrip) throws NullValueException, AlreadyExistException;

  /**
   * Update bus trip bus trip dto.
   *
   * @param busTrip the bus trip
   * @return the bus trip dto
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  BusTripDTO updateBusTrip(BusTripDTO busTrip) throws NullValueException, NotFoundException;
}
