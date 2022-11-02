package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;

public interface PlaneService {
  PlaneDTO addPlane(PlaneDTO plane) throws NullValueException;
  PlaneDTO updatePlane(PlaneDTO plane) throws NullValueException, NotFoundException;

}
