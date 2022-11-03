package com.exalt.transportationbookingsystem.service.rest.tripservice;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;

/**
 * The interface Flight service.
 */
public interface FlightService {

  /**
   * Add flight flight dto.
   *
   * @param flight the flight
   * @return the flight dto
   * @throws NullValueException    the null value exception
   * @throws AlreadyExistException the already exist exception
   */
  FlightDTO addFlight(FlightDTO flight) throws NullValueException, AlreadyExistException;

  /**
   * Update flight flight dto.
   *
   * @param flight the flight
   * @return the flight dto
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  FlightDTO updateFlight(FlightDTO flight) throws NullValueException, NotFoundException;

}
