package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;

/**
 * The interface Plane service.
 */
public interface PlaneService {

  /**
   * Add plane plane dto.
   *
   * @param plane the plane
   * @return the plane dto
   * @throws NullValueException the null value exception
   */
  PlaneDTO addPlane(PlaneDTO plane) throws NullValueException;

  /**
   * Update plane plane dto.
   *
   * @param plane the plane
   * @return the plane dto
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  PlaneDTO updatePlane(PlaneDTO plane) throws NullValueException, NotFoundException;

}
