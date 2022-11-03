package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import org.junit.jupiter.api.Test;

/**
 * The type Plane service impl test.
 */
class planeServiceImplTest {

  /**
   * The Plane service.
   */
  PlaneService planeService = new planeServiceImpl();

  /**
   * Add plane null value throws null value exception.
   */
  @Test
  void addPlane_NullValue_ThrowsNullValueException() {
    PlaneDTO plane = new PlaneDTO();
    assertThrows(NullValueException.class,
        ()-> {
          planeService.addPlane(plane);
        });
  }

  /**
   * Add plane new plane new record dto is consistent with returned record.
   *
   * @throws NullValueException the null value exception
   */
  @Test
  void addPlane_NewPlane_NewRecordDtoIsConsistentWithReturnedRecord() throws NullValueException {
    PlaneDTO newRecord = new PlaneDTO(3,"fsd566","france","f16","white",40,1,"china airport","china airlines");
    PlaneDTO retrievedRecord = planeService.addPlane(newRecord);
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getLicense().equals(retrievedRecord.getLicense()) &&
        newRecord.getManifacCountry().equals(retrievedRecord.getManifacCountry()) &&
        newRecord.getModel().equals(retrievedRecord.getModel()) &&
        newRecord.getColour().equals(retrievedRecord.getColour()) &&
        newRecord.getNoOfSeats() == retrievedRecord.getNoOfSeats() &&
        newRecord.getRefDriverId().equals(retrievedRecord.getRefDriverId()) &&
        newRecord.getAirport().equals(retrievedRecord.getAirport())&&
        newRecord.getAirlines().equals(retrievedRecord.getAirlines())
    );
  }

  /**
   * Update plane null value throws null value exception.
   */
  @Test
  void updatePlane_NullValue_ThrowsNullValueException() {
    PlaneDTO plane = new PlaneDTO();
    assertThrows(NullValueException.class,
        ()-> {
          planeService.updatePlane(plane);
        });
  }

  /**
   * Update plane not found id throws not found exception.
   */
  @Test
  void updatePlane_NotFoundId_ThrowsNotFoundException() {
    PlaneDTO plane = new PlaneDTO(30,"fsd566","france","f16","white",40,1,"china airport","china airlines");
    assertThrows(NotFoundException.class,
        ()-> {
          planeService.updatePlane(plane);
        });
  }

  /**
   * Update plane existing plane plane data updated.
   *
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  @Test
  void updatePlane_ExistingPlane_PlaneDataUpdated() throws NullValueException, NotFoundException {
    PlaneDTO existingPlane = new PlaneDTO(3,"fsd566","france","f16","white",40,1,"china airport","china airlines");
    PlaneDTO updates = new PlaneDTO(3,"qml566","Japan","q20","grey",45,1,"japan airport","japan airlines");
    PlaneDTO updatedPlane = planeService.updatePlane(updates);
    assertTrue(existingPlane.getId() == updatedPlane.getId() &&
        !existingPlane.getLicense().equals(updatedPlane.getLicense()) &&
        !existingPlane.getManifacCountry().equals(updatedPlane.getManifacCountry()) &&
        !existingPlane.getModel().equals(updatedPlane.getModel()) &&
        !existingPlane.getColour().equals(updatedPlane.getColour())&&
        existingPlane.getNoOfSeats() != updatedPlane.getNoOfSeats() &&
        !existingPlane.getAirlines().equals(updatedPlane.getAirlines())&&
        !existingPlane.getAirport().equals(updatedPlane.getAirport())
    );
  }
}