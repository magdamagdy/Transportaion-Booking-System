package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;

/**
 * The interface Bus service.
 */
public interface BusService {

  /**
   * Add bus bus dto.
   *
   * @param bus the bus
   * @return the bus dto
   * @throws NullValueException the null value exception
   */
  BusDTO addBus(BusDTO bus) throws NullValueException;

  /**
   * Update bus bus dto.
   *
   * @param bus the bus
   * @return the bus dto
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  BusDTO updateBus(BusDTO bus) throws NullValueException, NotFoundException;

}
