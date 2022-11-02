package com.exalt.transportationbookingsystem.dataaccess.tripdao;

import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import java.util.List;

/**
 * The interface Flight dao.
 */
public interface FlightDao {

  /**
   * Save flight.
   *
   * @param flight the flight
   */
  void saveFlight(FlightDB flight);

  /**
   * Update flight.
   *
   * @param flight the flight
   */
  void updateFlight(FlightDB flight);

  /**
   * Read flight by id flight db.
   *
   * @param id the id
   * @return the flight db
   */
  FlightDB readFlightById(int id);

  /**
   * Read all flights list.
   *
   * @return the list of all Flights
   */
  List<FlightDB> readAllFlights();

  /**
   * Delete flight by id.
   *
   * @param id the id
   */
  void deleteFlightById(int id);
}
