package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * The type Bus dao impl test.
 */
class busDaoImplTest {

  /**
   * The Bus dao.
   */
  BusDao busDao = new busDaoImpl();
  /**
   * The Driver.
   */
  DriverDB driver = new DriverDB(6,45,"male","012589367410","driver@gmail.com","dfb710",6,3.1F,7);

  /**
   * Save bus and read bus by id new bus new saved record is consistent with retrieved record.
   */
  @Test
  void saveBusAndReadBusById_NewBus_NewSavedRecordIsConsistentWithRetrievedRecord(){
    BusDB newRecord =  new BusDB(3,"fgp710","France","c80","red",50,driver);
    busDao.saveBus(newRecord);
    BusDB retrievedRecord = busDao.readBusById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getLicense().equals(retrievedRecord.getLicense()) &&
        newRecord.getManifacCountry().equals(retrievedRecord.getManifacCountry()) &&
        newRecord.getModel() .equals( retrievedRecord.getModel()) &&
        newRecord.getColour() .equals(retrievedRecord.getColour()) &&
        newRecord.getNoOfSeats() == retrievedRecord.getNoOfSeats()
    );
    busDao.deleteBusById(newRecord.getId());
  }

  /**
   * Update bus existing bus retrieved record is updated.
   */
  @Test
  void updateBus_ExistingBus_RetrievedRecordIsUpdated() {
    busDao.saveBus(new BusDB(4,"fgp710","France","c80","red",50,driver));
    BusDB ExistingBus =  busDao.readBusById(4);
    BusDB updates = new BusDB(4,"fop710","Germany","c20","blue",48,driver);
    busDao.updateBus(updates);
    BusDB updatedBus = busDao.readBusById(4);
    assertTrue(ExistingBus.getId() == updatedBus.getId() &&
        !ExistingBus.getLicense().equals(updatedBus.getLicense()) &&
        !ExistingBus.getManifacCountry().equals(updatedBus.getManifacCountry()) &&
        !ExistingBus.getModel().equals(updatedBus.getModel()) &&
        !ExistingBus.getColour().equals(updatedBus.getColour()) &&
        ExistingBus.getNoOfSeats() != updatedBus.getNoOfSeats());
    busDao.deleteBusById(ExistingBus.getId());
  }

  /**
   * Read all buses existing no of records list of records not null.
   */
  @Test
  void readAllBuses_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<BusDB> allRecords = new ArrayList<>(busDao.readAllBuses());
    assertTrue(allRecords.size() > 0);
  }

  /**
   * Delete bus by id existing bus getting null object after delete.
   */
  @Test
  void deleteBusById_ExistingBus_GettingNullObjectAfterDelete() {
    busDao.saveBus(new BusDB(5,"fga710","France","c80","red",50,driver));
    busDao.deleteBusById(5);
    assertNull(busDao.readBusById(5));
  }
}
