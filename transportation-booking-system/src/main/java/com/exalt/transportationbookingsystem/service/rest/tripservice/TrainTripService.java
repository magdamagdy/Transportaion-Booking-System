package com.exalt.transportationbookingsystem.service.rest.tripservice;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;

public interface TrainTripService {
  TrainTripDTO addTrainTrip(TrainTripDTO trainTrip) throws NullValueException, AlreadyExistException;
  TrainTripDTO updateTrainTrip(TrainTripDTO trainTrip) throws NullValueException, NotFoundException;

}
