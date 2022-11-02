package com.exalt.transportationbookingsystem.service.rest.tripservice;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;

public interface FlightService {
  FlightDTO addFlight(FlightDTO flight) throws NullValueException, AlreadyExistException;
  FlightDTO updateFlight(FlightDTO flight) throws NullValueException, NotFoundException;

}
