package com.exalt.transportationbookingsystem.dataaccess.tripdao;

import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import java.util.List;

public interface FlightDao {

  void saveFlight(FlightDB flight);
  void updateFlight(FlightDB flight);
  FlightDB readFlightById(int id);
  List<FlightDB> readAllFlights();
  void deleteFlightById(int id);
}
