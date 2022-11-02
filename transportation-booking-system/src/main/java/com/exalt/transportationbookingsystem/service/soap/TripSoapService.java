package com.exalt.transportationbookingsystem.service.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.dto.UserTripListsDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;

public interface TripSoapService {

  BusTripDTO getBusTripById(int id) throws NotFoundException;
  TrainTripDTO getTrainTripById(int id) throws NotFoundException;
  FlightDTO getFlightById(int id) throws NotFoundException;
  UserTripListsDTO getAllTripsByUserId (int id) throws NotFoundException;
}

