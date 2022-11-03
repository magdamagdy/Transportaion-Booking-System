package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import org.junit.jupiter.api.Test;

/**
 * The type Train service impl test.
 */
class trainServiceImplTest {

  /**
   * The Train service.
   */
  TrainService trainService = new trainServiceImpl();

  /**
   * Add train null value throws null value exception.
   */
  @Test
  void addTrain_NullValue_ThrowsNullValueException() {
    TrainDTO train = new TrainDTO();
    assertThrows(NullValueException.class,
        ()-> {
          trainService.addTrain(train);
        });
  }

  /**
   * Add train new train new record dto is consistent with returned record.
   *
   * @throws NullValueException the null value exception
   */
  @Test
  void addTrain_NewTrain_NewRecordDtoIsConsistentWithReturnedRecord() throws NullValueException {
    TrainDTO newRecord = new TrainDTO(3,"fsd566","france","fff03","white",40,1,"cairo railways");
    TrainDTO retrievedRecord = trainService.addTrain(newRecord);
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getLicense().equals(retrievedRecord.getLicense()) &&
        newRecord.getManifacCountry().equals(retrievedRecord.getManifacCountry()) &&
        newRecord.getModel().equals(retrievedRecord.getModel()) &&
        newRecord.getColour().equals(retrievedRecord.getColour()) &&
        newRecord.getNoOfSeats() == retrievedRecord.getNoOfSeats() &&
        newRecord.getRefDriverId().equals(retrievedRecord.getRefDriverId()) &&
        newRecord.getRailwayStation().equals(retrievedRecord.getRailwayStation())
    );
  }

  /**
   * Update train null value throws null value exception.
   */
  @Test
  void updateTrain_NullValue_ThrowsNullValueException() {
    TrainDTO train = new TrainDTO();
    assertThrows(NullValueException.class,
        ()-> {
          trainService.updateTrain(train);
        });
  }

  /**
   * Update train not found id throws not found exception.
   */
  @Test
  void updateTrain_NotFoundId_ThrowsNotFoundException() {
    TrainDTO train = new TrainDTO(30,"fsd566","france","fff03","white",40,1,"cairo railways");
    assertThrows(NotFoundException.class,
        ()-> {
          trainService.updateTrain(train);
        });
  }

  /**
   * Update train existing train train data updated.
   *
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  @Test
  void updateTrain_ExistingTrain_TrainDataUpdated() throws NullValueException, NotFoundException {
    TrainDTO existingTrain = new TrainDTO(3,"fsd566","france","fff03","white",40,1,"cairo railways");
    TrainDTO updates = new TrainDTO(3,"gty566","Germany","qgg40","blue",35,1,"Egypt railways");
    TrainDTO updatedTrain = trainService.updateTrain(updates);
    assertTrue(existingTrain.getId() == updatedTrain.getId() &&
        !existingTrain.getLicense().equals(updatedTrain.getLicense()) &&
        !existingTrain.getManifacCountry().equals(updatedTrain.getManifacCountry()) &&
        !existingTrain.getModel().equals(updatedTrain.getModel()) &&
        !existingTrain.getColour().equals(updatedTrain.getColour())&&
        existingTrain.getNoOfSeats() != updatedTrain.getNoOfSeats() &&
        !existingTrain.getRailwayStation().equals(updatedTrain.getRailwayStation())
    );
  }

}