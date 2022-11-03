package com.exalt.transportationbookingsystem.service.rest.tripservice;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import org.junit.jupiter.api.Test;

class flightServiceImplTest {

  FlightService flightService = new flightServiceImpl();
  @Test
  void addFlight_NullValue_ThrowsNullValueException() {
    FlightDTO flight = new FlightDTO();
    assertThrows(NullValueException.class,
        () -> {
          flightService.addFlight(flight);
        });
  }

  @Test
  void addFlight_ExistingFlight_ThrowsAlreadyExistException() {
    FlightDTO flight = new FlightDTO(1,"22-9-2022",60,"3:00","5:00","cairo","sharm el sheikh",1,"Class B",1);
    assertThrows(AlreadyExistException.class,
        () -> {
          flightService.addFlight(flight);
        });
  }

  @Test
  void addFlight_NewFlight_NewRecordDtoIsConsistentWithReturnedRecord() throws NullValueException, AlreadyExistException {
    FlightDTO newRecord = new FlightDTO(2,"22-9-2022",60,"3:00","5:00","cairo","sharm el sheikh",1,"Class B",1);
    FlightDTO retrievedRecord = flightService.addFlight(newRecord);
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getDate().equals(retrievedRecord.getDate()) &&
        newRecord.getSeatNo() == retrievedRecord.getSeatNo() &&
        newRecord.getDepartureTime().equals(retrievedRecord.getDepartureTime()) &&
        newRecord.getArrivalTime().equals(retrievedRecord.getArrivalTime()) &&
        newRecord.getStartLocation().equals(retrievedRecord.getStartLocation()) &&
        newRecord.getDestination().equals(retrievedRecord.getDestination()) &&
        newRecord.getRefUserId().equals(retrievedRecord.getRefUserId()) &&
        newRecord.getRefPlaneId().equals(retrievedRecord.getRefPlaneId()) &&
        newRecord.getFlightClass().equals(retrievedRecord.getFlightClass())
    );
  }

  @Test
  void updateFlight_NullValue_ThrowsNullValueException() {
    FlightDTO flight = new FlightDTO();
    assertThrows(NullValueException.class,
        () -> {
          flightService.updateFlight(flight);
        });
  }

  @Test
  void updateFlight_NotFoundId_ThrowsNotFoundException() {
    FlightDTO flight = new FlightDTO(20,"22-9-2022",60,"3:00","5:00","cairo","sharm el sheikh",1,"Class B",1);
    assertThrows(NotFoundException.class,
        () -> {
          flightService.updateFlight(flight);
        });
  }

  @Test
  void updateFlight_ExistingFlight_FlightDataUpdated() throws NullValueException, NotFoundException {
    FlightDTO existingFlight = new FlightDTO(2,"22-9-2022",60,"3:00","5:00","cairo","sharm el sheikh",1,"Class B",1);
    FlightDTO updates = new FlightDTO(2,"12-9-2022",20,"3:00","5:00","cairo","sharm el sheikh",1,"Class A",1);
    FlightDTO updatedFlight = flightService.updateFlight(updates);
    assertTrue(existingFlight.getId() == updatedFlight.getId() &&
        !existingFlight.getDate().equals(updatedFlight.getDate()) &&
        existingFlight.getSeatNo() != updatedFlight.getSeatNo() &&
        existingFlight.getDepartureTime().equals(updatedFlight.getDepartureTime()) &&
        existingFlight.getArrivalTime().equals(updatedFlight.getArrivalTime()) &&
        existingFlight.getStartLocation().equals(updatedFlight.getStartLocation()) &&
        existingFlight.getDestination().equals(updatedFlight.getDestination()) &&
        existingFlight.getRefUserId().equals(updatedFlight.getRefUserId()) &&
        existingFlight.getRefPlaneId().equals(updatedFlight.getRefPlaneId()) &&
        !existingFlight.getFlightClass().equals(updatedFlight.getFlightClass())
    );
  }
}