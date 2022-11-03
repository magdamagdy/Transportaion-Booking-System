package com.exalt.transportationbookingsystem.dataaccess.triprepository;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * The type Train trip dao impl test.
 */
class TrainTripRepositoryTest {

  /**
   * The Train trip dao.
   */
  TrainTripRepository trainTripDao = new TrainTripRepositoryImpl();
  /**
   * The Driver.
   */
  DriverDB driver = new DriverDB(7,45,"male","012589367410","driver@gmail.com","dfb710",6,3.1F,7);
  /**
   * The Train.
   */
  TrainDB train = new TrainDB(6, "DFQ262","Germany","fff-890","blue",300,driver,"Egypt Railways");
  /**
   * The User.
   */
  UserDB user = new UserDB(8,19,"female","01223699874","user@gmail.com");

  /**
   * Save and read train trip by id new train trip new saved record is consistent with retrieved
   * record.
   */
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

  /**
   * Update train trip existing train trip retrieved record is updated.
   */
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

  /**
   * Read all train trips existing no of records list of records not null.
   */
  @Test
  void readAllTrainTrips_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<TrainTripDB> allRecords = new ArrayList<>(trainTripDao.readAllTrainTrips());
    assertTrue(allRecords.size() > 0);
  }

  /**
   * Delete train trip by id existing train trip getting null object after delete.
   */
  @Test
  void deleteTrainTripById_ExistingTrainTrip_GettingNullObjectAfterDelete() {
    trainTripDao.saveTrainTrip(new TrainTripDB(4,"12-05-2022",30,"1:00","6:00","Cairo","Mansora",user,"Class A",train));
    trainTripDao.deleteTrainTripById(4);
    assertNull(trainTripDao.readTrainTripById(4));
  }
}