package com.exalt.transportationbookingsystem.service.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.dto.UserTripListsDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;

/**
 * The interface Trip soap service.
 */
public interface TripSoapService {

  /**
   * Gets bus trip by id.
   *
   * @param id the id
   * @return the bus trip by id
   * @throws NotFoundException the not found exception
   */
  BusTripDTO getBusTripById(int id) throws NotFoundException;

  /**
   * Gets train trip by id.
   *
   * @param id the id
   * @return the train trip by id
   * @throws NotFoundException the not found exception
   */
  TrainTripDTO getTrainTripById(int id) throws NotFoundException;

  /**
   * Gets flight by id.
   *
   * @param id the id
   * @return the flight by id
   * @throws NotFoundException the not found exception
   */
  FlightDTO getFlightById(int id) throws NotFoundException;

  /**
   * Gets all trips by user id.
   * get all trips booked by this user
   * @param id the id
   * @return the all trips by user id
   * @throws NotFoundException the not found exception
   */
  UserTripListsDTO getAllTripsByUserId (int id) throws NotFoundException;
}

