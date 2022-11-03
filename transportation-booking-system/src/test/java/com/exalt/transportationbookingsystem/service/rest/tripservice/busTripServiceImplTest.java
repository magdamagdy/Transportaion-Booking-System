package com.exalt.transportationbookingsystem.service.rest.tripservice;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import org.junit.jupiter.api.Test;

/**
 * The type Bus trip service impl test.
 */
class busTripServiceImplTest {

  /**
   * The Bus trip service.
   */
  BusTripService busTripService = new busTripServiceImpl();

  /**
   * Add bus trip null value throws null value exception.
   */
  @Test
  void addBusTrip_NullValue_ThrowsNullValueException() {
    BusTripDTO busTrip = new BusTripDTO();
    assertThrows(NullValueException.class,
        () -> {
          busTripService.addBusTrip(busTrip);
        });
  }

  /**
   * Add bus trip existing trip throws already exist exception.
   */
  @Test
  void addBusTrip_ExistingTrip_ThrowsAlreadyExistException() {
    BusTripDTO busTrip = new BusTripDTO(1,"22-6-2021",5,"3:30","5:00","cairo","Alex",1,1);
    assertThrows(AlreadyExistException.class,
        () -> {
          busTripService.addBusTrip(busTrip);
        });
  }

  /**
   * Add bus trip new bus trip new record dto is consistent with returned record.
   *
   * @throws NullValueException    the null value exception
   * @throws AlreadyExistException the already exist exception
   */
  @Test
  void addBusTrip_NewBusTrip_NewRecordDtoIsConsistentWithReturnedRecord() throws NullValueException, AlreadyExistException {
    BusTripDTO newRecord = new BusTripDTO(2, "5-12-2022", 5, "2:30", "5:00", "cairo", "Alex", 1, 1);
    BusTripDTO retrievedRecord = busTripService.addBusTrip(newRecord);
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getDate().equals(retrievedRecord.getDate()) &&
        newRecord.getSeatNo() == retrievedRecord.getSeatNo() &&
        newRecord.getDepartureTime().equals(retrievedRecord.getDepartureTime()) &&
        newRecord.getArrivalTime().equals(retrievedRecord.getArrivalTime()) &&
        newRecord.getStartLocation().equals(retrievedRecord.getStartLocation()) &&
        newRecord.getDestination().equals(retrievedRecord.getDestination()) &&
        newRecord.getRefUserId().equals(retrievedRecord.getRefUserId()) &&
        newRecord.getRefBusId().equals(retrievedRecord.getRefBusId())
    );
  }

  /**
   * Update bus trip null value throws null value exception.
   */
  @Test
  void updateBusTrip_NullValue_ThrowsNullValueException() {
    BusTripDTO busTrip = new BusTripDTO();
    assertThrows(NullValueException.class,
        () -> {
          busTripService.updateBusTrip(busTrip);
        });
  }

  /**
   * Update bus trip not found id throws not found exception.
   */
  @Test
  void updateBusTrip_NotFoundId_ThrowsNotFoundException() {
    BusTripDTO busTrip = new BusTripDTO(20, "5-12-2022", 5, "2:30", "5:00", "cairo", "Alex", 1, 1);
    assertThrows(NotFoundException.class,
        () -> {
          busTripService.updateBusTrip(busTrip);
        });
  }

  /**
   * Update bus trip existing bus trip bus trip data updated.
   *
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  @Test
  void updateBusTrip_ExistingBusTrip_BusTripDataUpdated() throws NullValueException, NotFoundException {
    BusTripDTO existingBusTrip = new BusTripDTO(2, "5-12-2022", 5, "2:30", "5:00", "cairo", "Alex", 1, 1);
    BusTripDTO updates = new BusTripDTO(2,"30-10-2022",6,"2:30", "5:00", "cairo", "Alex", 1, 1);
    BusTripDTO updatedBusTrip = busTripService.updateBusTrip(updates);
    assertTrue(existingBusTrip.getId() == updatedBusTrip.getId() &&
        !existingBusTrip.getDate().equals(updatedBusTrip.getDate()) &&
        existingBusTrip.getSeatNo() != updatedBusTrip.getSeatNo() &&
        existingBusTrip.getDepartureTime().equals(updatedBusTrip.getDepartureTime()) &&
        existingBusTrip.getArrivalTime().equals(updatedBusTrip.getArrivalTime()) &&
        existingBusTrip.getStartLocation().equals(updatedBusTrip.getStartLocation()) &&
        existingBusTrip.getDestination().equals(updatedBusTrip.getDestination()) &&
        existingBusTrip.getRefUserId().equals(updatedBusTrip.getRefUserId()) &&
        existingBusTrip.getRefBusId().equals(updatedBusTrip.getRefBusId())
    );
  }
}