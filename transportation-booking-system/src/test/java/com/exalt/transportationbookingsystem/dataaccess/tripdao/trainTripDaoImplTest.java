package com.exalt.transportationbookingsystem.dataaccess.tripdao;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class trainTripDaoImplTest {
  TrainTripDao trainTripDao = new trainTripDaoImpl();
  DriverDB driver = new DriverDB(7,45,"male","012589367410","driver@gmail.com","dfb710",6,3.1F,7);
  TrainDB train = new TrainDB(6, "DFQ262","Germany","fff-890","blue",300,driver,"Egypt Railways");
  UserDB user = new UserDB(8,19,"female","01223699874","user@gmail.com");

  @Test
  void saveAndReadTrainTripById_NewTrainTrip_NewSavedRecordIsConsistentWithRetrievedRecord(){
    TrainTripDB newRecord =  new TrainTripDB(2,"19-05-2022",20,"1:00","6:00","Cairo","Mansoura",user,"Class A",train);
    trainTripDao.saveTrainTrip(newRecord);
    TrainTripDB retrievedRecord = trainTripDao.readTrainTripById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getDate().equals(retrievedRecord.getDate()) &&
        newRecord.getSeatNo() == retrievedRecord.getSeatNo() &&
        newRecord.getDepartureTime().equals(retrievedRecord.getDepartureTime()) &&
        newRecord.getArrivalTime().equals(retrievedRecord.getArrivalTime()) &&
        newRecord.getStartLocation().equals(retrievedRecord.getStartLocation()) &&
        newRecord.getDestination().equals(retrievedRecord.getDestination()) &&
        newRecord.getUser().getId() == retrievedRecord.getUser().getId() &&
        newRecord.getTrain().getId() == retrievedRecord.getTrain().getId() &&
        newRecord.getTrainClass().equals(retrievedRecord.getTrainClass())
    );
    trainTripDao.deleteTrainTripById(newRecord.getId());
  }

  @Test
  void updateTrainTrip_ExistingTrainTrip_RetrievedRecordIsUpdated() {
    trainTripDao.saveTrainTrip(
        new TrainTripDB(3,"17-05-2022",20,"1:00","6:00","Cairo","Mansora",user,"Class A",train));
    TrainTripDB ExistingTrainTrip = trainTripDao.readTrainTripById(3);
    TrainTripDB updates = new TrainTripDB(3,"19-05-2022",22,"1:00","6:00","Cairo","Mansora",user,"Class B",train);
    trainTripDao.updateTrainTrip(updates);
    TrainTripDB updatedTrainTrip = trainTripDao.readTrainTripById(3);
    assertTrue(ExistingTrainTrip.getId() == updatedTrainTrip.getId() &&
        !ExistingTrainTrip.getDate().equals(updatedTrainTrip.getDate()) &&
        ExistingTrainTrip.getSeatNo() != updatedTrainTrip.getSeatNo() &&
        ExistingTrainTrip.getDepartureTime().equals(updatedTrainTrip.getDepartureTime()) &&
        ExistingTrainTrip.getArrivalTime().equals(updatedTrainTrip.getArrivalTime()) &&
        ExistingTrainTrip.getStartLocation().equals(updatedTrainTrip.getStartLocation()) &&
        ExistingTrainTrip.getDestination().equals(updatedTrainTrip.getDestination()) &&
        ExistingTrainTrip.getUser().getId() == updatedTrainTrip.getUser().getId() &&
        ExistingTrainTrip.getTrain().getId() == updatedTrainTrip.getTrain().getId() &&
        ExistingTrainTrip.getTrainClass().equals(updatedTrainTrip.getTrainClass()));
    trainTripDao.deleteTrainTripById(ExistingTrainTrip.getId());
  }

  @Test
  void readAllTrainTrips_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<TrainTripDB> allRecords = new ArrayList<>(trainTripDao.readAllTrainTrips());
    assertTrue(allRecords.size() > 0);
  }

  @Test
  void deleteTrainTripById_ExistingTrainTrip_GettingNullObjectAfterDelete() {
    trainTripDao.saveTrainTrip(new TrainTripDB(4,"12-05-2022",30,"1:00","6:00","Cairo","Mansora",user,"Class A",train));
    trainTripDao.deleteTrainTripById(4);
    assertNull(trainTripDao.readTrainTripById(4));
  }
}