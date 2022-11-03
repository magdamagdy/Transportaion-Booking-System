package com.exalt.transportationbookingsystem.service.rest.personservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;

/**
 * The interface Driver service.
 */
public interface DriverService {

  /**
   * Add driver driver dto.
   *
   * @param driver the driver
   * @return the driver dto
   * @throws NullValueException the null value exception
   */
  DriverDTO addDriver(DriverDTO driver) throws NullValueException;

  /**
   * Update driver driver dto.
   *
   * @param driver the driver
   * @return the driver dto
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  DriverDTO updateDriver(DriverDTO driver) throws NullValueException, NotFoundException;
}
