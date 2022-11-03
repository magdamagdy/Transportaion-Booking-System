package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class planeDaoImplTest {
  PlaneDao planeDao = new planeDaoImpl();
  DriverDB driver = new DriverDB(6,45,"male","012589367410","driver@gmail.com","dfb710",6,3.1F,7);

  @Test
  void savePlaneAndReadPlaneById_NewPlane_NewSavedRecordIsConsistentWithRetrievedRecord(){
    PlaneDB newRecord =  new PlaneDB(3,"fgp710","France","f16-02","red",50,driver,"Cairo Airport","Egypt Airlines");
    planeDao.savePlane(newRecord);
    PlaneDB retrievedRecord = planeDao.readPlaneById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getLicense().equals(retrievedRecord.getLicense()) &&
        newRecord.getManifacCountry().equals(retrievedRecord.getManifacCountry()) &&
        newRecord.getModel() .equals( retrievedRecord.getModel()) &&
        newRecord.getColour() .equals(retrievedRecord.getColour()) &&
        newRecord.getNoOfSeats() == retrievedRecord.getNoOfSeats() &&
        newRecord.getAirport().equals(retrievedRecord.getAirport()) &&
        newRecord.getAirlines().equals(retrievedRecord.getAirlines())
    );
    planeDao.deletePlaneById(newRecord.getId());
  }

  @Test
  void updatePlane_ExistingPlane_RetrievedRecordIsUpdated() {
    planeDao.savePlane(new PlaneDB(4,"fgp710","France","f16-02","red",50,driver,"Cairo Airport","Egypt Airlines"));
    PlaneDB ExistingPlane =  planeDao.readPlaneById(4);
    PlaneDB updates = new PlaneDB(4,"TUp710","Germany","f20-02","grey",60,driver,"NewYork Airport","US Airlines");
    planeDao.updatePlane(updates);
    PlaneDB updatedPlane = planeDao.readPlaneById(4);
    assertTrue(ExistingPlane.getId() == updatedPlane.getId() &&
        !ExistingPlane.getLicense().equals(updatedPlane.getLicense()) &&
        !ExistingPlane.getManifacCountry().equals(updatedPlane.getManifacCountry()) &&
        !ExistingPlane.getModel().equals(updatedPlane.getModel()) &&
        !ExistingPlane.getColour().equals(updatedPlane.getColour()) &&
        ExistingPlane.getNoOfSeats() != updatedPlane.getNoOfSeats() &&
        !ExistingPlane.getAirlines().equals(updatedPlane.getAirlines()) &&
        !ExistingPlane.getAirport().equals(updatedPlane.getAirport())
    );
    planeDao.deletePlaneById(ExistingPlane.getId());
  }

  @Test
  void readAllPlanes_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<PlaneDB> allRecords = new ArrayList<>(planeDao.readAllPlanes());
    assertTrue(allRecords.size() > 0);
  }

  @Test
  void deletePlaneById_ExistingPlane_GettingNullObjectAfterDelete() {
    planeDao.savePlane(new PlaneDB(5,"klp710","France","f16-02","red",50,driver,"Cairo Airport","Egypt Airlines"));
    planeDao.deletePlaneById(5);
    assertNull(planeDao.readPlaneById(5));
  }
}