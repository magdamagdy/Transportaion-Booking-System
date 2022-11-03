package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import org.junit.jupiter.api.Test;

/**
 * The type Bus service impl test.
 */
class busServiceImplTest {

  /**
   * The Bus service.
   */
  BusService busService = new busServiceImpl();

  /**
   * Add bus null value throws null value exception.
   */
  @Test
  void addBus_NullValue_ThrowsNullValueException() {
    BusDTO bus = new BusDTO();
    assertThrows(NullValueException.class,
        ()-> {
          busService.addBus(bus);
        });
  }

  /**
   * Add bus new bus new record dto is consistent with returned record.
   *
   * @throws NullValueException the null value exception
   */
  @Test
  void addBus_NewBus_NewRecordDtoIsConsistentWithReturnedRecord() throws NullValueException {
    BusDTO newRecord = new BusDTO(3,"fsd566","china","c60","red",14,1);
    BusDTO retrievedRecord = busService.addBus(newRecord);
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getLicense().equals(retrievedRecord.getLicense()) &&
        newRecord.getManifacCountry().equals(retrievedRecord.getManifacCountry()) &&
        newRecord.getModel().equals(retrievedRecord.getModel()) &&
        newRecord.getColour().equals(retrievedRecord.getColour()) &&
        newRecord.getNoOfSeats() == retrievedRecord.getNoOfSeats() &&
        newRecord.getRefDriverId().equals(retrievedRecord.getRefDriverId())
    );
  }

  /**
   * Update bus null value throws null value exception.
   */
  @Test
  void updateBus_NullValue_ThrowsNullValueException() {
    BusDTO bus = new BusDTO();
    assertThrows(NullValueException.class,
        ()-> {
          busService.updateBus(bus);
        });
  }

  /**
   * Update bus not found id throws not found exception.
   */
  @Test
  void updateBus_NotFoundId_ThrowsNotFoundException() {
    BusDTO bus = new BusDTO(30,"fsd566","china","c60","red",14,1);
    assertThrows(NotFoundException.class,
        ()-> {
          busService.updateBus(bus);
        });
  }

  /**
   * Update bus existing bus bus data updated.
   *
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  @Test
  void updateBus_ExistingBus_BusDataUpdated() throws NullValueException, NotFoundException {
    BusDTO existingBus = new BusDTO(3,"fsd566","china","c60","red",14,1);
    BusDTO updates = new BusDTO(3,"asd566","Japan","c90","white",32,1);
    BusDTO updatedBus = busService.updateBus(updates);
    assertTrue(existingBus.getId() == updatedBus.getId() &&
        !existingBus.getLicense().equals(updatedBus.getLicense()) &&
        !existingBus.getManifacCountry().equals(updatedBus.getManifacCountry()) &&
        !existingBus.getModel().equals(updatedBus.getModel()) &&
        !existingBus.getColour().equals(updatedBus.getColour())&&
        existingBus.getNoOfSeats() != updatedBus.getNoOfSeats()
    );
  }
}