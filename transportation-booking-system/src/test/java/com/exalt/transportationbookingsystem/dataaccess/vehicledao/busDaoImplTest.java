package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class busDaoImplTest {
  BusDao busDao = new busDaoImpl();
  DriverDB driver = new DriverDB(6,45,"male","012589367410","driver@gmail.com","dfb710",6,3.1F,7);

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
        newRecord.getNoOfSeats() == retrievedRecord.getNoOfSeats() &&
        newRecord.getDriver().getId() == retrievedRecord.getDriver().getId()
    );
    busDao.deleteBusById(newRecord.getId());
  }

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

  @Test
  void readAllBuses_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<BusDB> allRecords = new ArrayList<>(busDao.readAllBuses());
    assertTrue(allRecords.size() > 0);
  }

  @Test
  void deleteBusById_ExistingBus_GettingNullObjectAfterDelete() {
    busDao.saveBus(new BusDB(5,"fga710","France","c80","red",50,driver));
    busDao.deleteBusById(5);
    assertEquals(busDao.readBusById(5), null);
  }
}
