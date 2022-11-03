package com.exalt.transportationbookingsystem.service.rest.tripservice;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;
import org.junit.jupiter.api.Test;

/**
 * The type Train trip service impl test.
 */
class trainTripServiceImplTest {

  /**
   * The Train trip service.
   */
  TrainTripService trainTripService = new trainTripServiceImpl();

  /**
   * Add train trip null value throws null value exception.
   */
  @Test
  void addTrainTrip_NullValue_ThrowsNullValueException() {
    TrainTripDTO trainTrip = new TrainTripDTO();
    assertThrows(NullValueException.class,
        () -> {
          trainTripService.addTrainTrip(trainTrip);
        });
  }

  /**
   * Add train trip existing train trip throws already exist exception.
   */
  @Test
  void addTrainTrip_ExistingTrainTrip_ThrowsAlreadyExistException() {
    TrainTripDTO trainTrip = new TrainTripDTO(1,"22-9-2022",60,"3:00","12:00","cairo","sharm el sheikh",1,"Class B",1);
    assertThrows(AlreadyExistException.class,
        () -> {
          trainTripService.addTrainTrip(trainTrip);
        });
  }

  /**
   * Add train trip new train trip new record dto is consistent with returned record.
   *
   * @throws NullValueException    the null value exception
   * @throws AlreadyExistException the already exist exception
   */
  @Test
  void addTrainTrip_NewTrainTrip_NewRecordDtoIsConsistentWithReturnedRecord() throws NullValueException, AlreadyExistException {
    TrainTripDTO newRecord = new TrainTripDTO(2,"22-9-2022",60,"3:00","12:00","cairo","sharm el sheikh",1,"Class B",1);
    TrainTripDTO retrievedRecord = trainTripService.addTrainTrip(newRecord);
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getDate().equals(retrievedRecord.getDate()) &&
        newRecord.getSeatNo() == retrievedRecord.getSeatNo() &&
        newRecord.getDepartureTime().equals(retrievedRecord.getDepartureTime()) &&
        newRecord.getArrivalTime().equals(retrievedRecord.getArrivalTime()) &&
        newRecord.getStartLocation().equals(retrievedRecord.getStartLocation()) &&
        newRecord.getDestination().equals(retrievedRecord.getDestination()) &&
        newRecord.getRefUserId().equals(retrievedRecord.getRefUserId()) &&
        newRecord.getRefTrainId().equals(retrievedRecord.getRefTrainId()) &&
        newRecord.getTrainClass().equals(retrievedRecord.getTrainClass())
    );
  }

  /**
   * Update train trip null value throws null value exception.
   */
  @Test
  void updateTrainTrip_NullValue_ThrowsNullValueException() {
    TrainTripDTO trainTrip = new TrainTripDTO();
    assertThrows(NullValueException.class,
        () -> {
          trainTripService.updateTrainTrip(trainTrip);
        });
  }

  /**
   * Update train trip not found id throws not found exception.
   */
  @Test
  void updateTrainTrip_NotFoundId_ThrowsNotFoundException() {
    TrainTripDTO trainTrip = new TrainTripDTO(20,"22-9-2022",60,"3:00","5:00","cairo","sharm el sheikh",1,"Class B",1);
    assertThrows(NotFoundException.class,
        () -> {
          trainTripService.updateTrainTrip(trainTrip);
        });
  }

  /**
   * Update train trip existing train trip train trip data updated.
   *
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  @Test
  void updateTrainTrip_ExistingTrainTrip_TrainTripDataUpdated() throws NullValueException, NotFoundException {
    TrainTripDTO existingTrainTrip = new TrainTripDTO(2,"22-9-2022",60,"3:00","5:00","cairo","sharm el sheikh",1,"Class B",1);
    TrainTripDTO updates = new TrainTripDTO(2,"12-9-2022",20,"3:00","5:00","cairo","sharm el sheikh",1,"Class A",1);
    TrainTripDTO updatedTrainTrip = trainTripService.updateTrainTrip(updates);
    assertTrue(existingTrainTrip.getId() == updatedTrainTrip.getId() &&
        !existingTrainTrip.getDate().equals(updatedTrainTrip.getDate()) &&
        existingTrainTrip.getSeatNo() != updatedTrainTrip.getSeatNo() &&
        existingTrainTrip.getDepartureTime().equals(updatedTrainTrip.getDepartureTime()) &&
        existingTrainTrip.getArrivalTime().equals(updatedTrainTrip.getArrivalTime()) &&
        existingTrainTrip.getStartLocation().equals(updatedTrainTrip.getStartLocation()) &&
        existingTrainTrip.getDestination().equals(updatedTrainTrip.getDestination()) &&
        existingTrainTrip.getRefUserId().equals(updatedTrainTrip.getRefUserId()) &&
        existingTrainTrip.getRefTrainId().equals(updatedTrainTrip.getRefTrainId()) &&
        !existingTrainTrip.getTrainClass().equals(updatedTrainTrip.getTrainClass())
    );
  }
}