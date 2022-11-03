package com.exalt.transportationbookingsystem.service.rest.personservice;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import org.junit.jupiter.api.Test;

/**
 * The type Driver service impl test.
 */
class driverServiceImplTest {

  /**
   * The Driver service.
   */
  DriverService driverService = new driverServiceImpl();

  /**
   * Add driver null value throws null value exception.
   */
  @Test
  void addDriver_NullValue_ThrowsNullValueException() {
    DriverDTO driver = new DriverDTO();
    assertThrows(NullValueException.class,
        ()-> {
      driverService.addDriver(driver);
        });
  }

  /**
   * Add driver new driver new record dto is consistent with returned record.
   *
   * @throws NullValueException the null value exception
   */
  @Test
  void addDriver_NewDriver_NewRecordDtoIsConsistentWithReturnedRecord() throws NullValueException {
    DriverDTO newRecord = new DriverDTO(4,50,"male","01248936711","driverdto@gmail.com","hol459",6,4F,4);
    DriverDTO retrievedRecord = driverService.addDriver(newRecord);
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getAge() == retrievedRecord.getAge() &&
        newRecord.getGender().equals(retrievedRecord.getGender()) &&
        newRecord.getPhone().equals(retrievedRecord.getPhone()) &&
        newRecord.getEmail().equals(retrievedRecord.getEmail()) &&
        newRecord.getLicense().equals(retrievedRecord.getLicense())&&
        newRecord.getYearsOfExp() == retrievedRecord.getYearsOfExp() &&
        newRecord.getRate().equals(retrievedRecord.getRate()) &&
        newRecord.getNoOfRatings() == retrievedRecord.getNoOfRatings()
    );
  }

  /**
   * Update driver null value throws null value exception.
   */
  @Test
  void updateDriver_NullValue_ThrowsNullValueException() {
    DriverDTO driver = new DriverDTO();
    assertThrows(NullValueException.class,
        ()-> {
          driverService.addDriver(driver);
        });
  }

  /**
   * Update driver not found id throws not found exception.
   */
  @Test
  void updateDriver_NotFoundId_ThrowsNotFoundException() {
    DriverDTO driver = new DriverDTO(20,60,"female","012662618231","driver@gamil.com","hlp970",6,5F,1);
    assertThrows(NotFoundException.class,
        ()-> {
          driverService.updateDriver(driver);
        });
  }

  /**
   * Update driver existing driver driver data updated.
   *
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  @Test
  void updateDriver_ExistingDriver_DriverDataUpdated() throws NullValueException, NotFoundException {
    DriverDTO existingDriver = new DriverDTO(4,50,"male","01248936711","driverdto@gmail.com","hol459",6,4F,4);
    DriverDTO updates = new DriverDTO(4,45,"female","01296736711","driver@gmail.com","bnl459",7,4F,4);
    DriverDTO updatedDriver = driverService.updateDriver(updates);
    assertTrue(existingDriver.getId() == updatedDriver.getId() &&
        existingDriver.getAge() != updatedDriver.getAge() &&
        !existingDriver.getGender().equals(updatedDriver.getGender()) &&
        !existingDriver.getPhone().equals(updatedDriver.getPhone()) &&
        !existingDriver.getEmail().equals(updatedDriver.getEmail()) &&
        !existingDriver.getLicense().equals(updatedDriver.getLicense())&&
        existingDriver.getYearsOfExp() != updatedDriver.getYearsOfExp()
    );
  }
}