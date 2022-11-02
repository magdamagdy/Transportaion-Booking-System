package com.exalt.transportationbookingsystem.service.rest.tripservice;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;

public interface BusTripService {

  BusTripDTO addBusTrip(BusTripDTO busTrip) throws NullValueException, AlreadyExistException;
  BusTripDTO updateBusTrip(BusTripDTO busTrip) throws NullValueException, NotFoundException;
}
