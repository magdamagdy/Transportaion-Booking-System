package com.exalt.transportationbookingsystem.dataaccess.personrepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


/**
 * The type Driver dao impl test.
 */
class DriverRepositoryTest {

  /**
   * The Driver dao.
   */
  DriverRepository driverDao = new DriverRepositoryImpl();

  /**
   * Save and read driver by id new driver new saved record is consistent with retrieved record.
   */
  @Test
  void saveAndReadDriverById_NewDriver_NewSavedRecordIsConsistentWithRetrievedRecord(){
    DriverDB newRecord =  new DriverDB(4,47,"male","01296371842","testDriver@gmail.com",
        "qsb970",10,4F,50);
    driverDao.saveDriver(newRecord);
    DriverDB retrievedRecord = driverDao.readDriverById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getAge() == retrievedRecord.getAge() &&
        newRecord.getGender().equals(retrievedRecord.getGender()) &&
        newRecord.getPhone() .equals( retrievedRecord.getPhone()) &&
        newRecord.getEmail() .equals(retrievedRecord.getEmail()) &&
        newRecord.getLicense() .equals(retrievedRecord.getLicense()) &&
        newRecord.getYearsOfExp() == retrievedRecord.getYearsOfExp() &&
        newRecord.getRate() .equals( retrievedRecord.getRate()) &&
        newRecord.getNoOfRatings() == retrievedRecord.getNoOfRatings()
        );
    driverDao.deleteDriverById(newRecord.getId());
  }

  /**
   * Update driver existing driver retrieved record is updated.
   */
  @Test
  void updateDriver_ExistingDriver_RetrievedRecordIsUpdated() {
    driverDao.saveDriver(new DriverDB(5,41,"female","01519840002","test1Driver@gmail.com",
        "sdb901",9,3.5F,46));
    DriverDB ExistingDriver =  driverDao.readDriverById(5);
    DriverDB updates = new DriverDB(5,40,"male","01296300002","test2Driver@gmail.com",
        "fbb901",8,3.5F, 46);
    driverDao.updateDriver(updates);
    DriverDB UpdatedDriver = driverDao.readDriverById(5);
    assertTrue(ExistingDriver.getId() == UpdatedDriver.getId() &&
        ExistingDriver.getAge() != UpdatedDriver.getAge() &&
        !ExistingDriver.getGender().equals(UpdatedDriver.getGender()) &&
        !ExistingDriver.getPhone().equals(UpdatedDriver.getPhone()) &&
        !ExistingDriver.getEmail().equals(UpdatedDriver.getEmail()) &&
        !ExistingDriver.getLicense().equals(UpdatedDriver.getLicense()) &&
        ExistingDriver.getYearsOfExp() != UpdatedDriver.getYearsOfExp());
    driverDao.deleteDriverById(ExistingDriver.getId());
  }

  /**
   * Read all drivers existing no of records list of records not null.
   */
  @Test
  void readAllDrivers_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<DriverDB> allRecords = new ArrayList<>(driverDao.readAllDrivers());
    assertTrue(allRecords.size() > 0);
  }

  /**
   * Delete driver by id existing driver getting null object after delete.
   */
  @Test
  void deleteDriverById_ExistingDriver_GettingNullObjectAfterDelete() {
    driverDao.saveDriver(new DriverDB(6,40,"male","01096300002","test3Driver@gmail.com",
        "jkb901",8,5F,9));
    driverDao.deleteDriverById(6);
    assertNull(driverDao.readDriverById(6));
  }


}