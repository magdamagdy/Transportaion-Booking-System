package com.exalt.transportationbookingsystem.service.rest.personservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;

public interface DriverService {
  DriverDTO addDriver(DriverDTO driver) throws NullValueException;
  DriverDTO updateDriver(DriverDTO driver) throws NullValueException, NotFoundException;
}
