package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class trainDaoImplTest {
  TrainDao trainDao = new trainDaoImpl();
  DriverDB driver = new DriverDB(6,45,"male","012589367410","driver@gmail.com","dfb710",6,3.1F,7);

  @Test
  void saveTrainAndReadTrainById_NewTrain_NewSavedRecordIsConsistentWithRetrievedRecord(){
    TrainDB newRecord =  new TrainDB(3,"fgp710","France","c80","red",50,driver,"Cairo Railways");
    trainDao.saveTrain(newRecord);
    TrainDB retrievedRecord = trainDao.readTrainById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getLicense().equals(retrievedRecord.getLicense()) &&
        newRecord.getManifacCountry().equals(retrievedRecord.getManifacCountry()) &&
        newRecord.getModel() .equals( retrievedRecord.getModel()) &&
        newRecord.getColour() .equals(retrievedRecord.getColour()) &&
        newRecord.getNoOfSeats() == retrievedRecord.getNoOfSeats() &&
        newRecord.getRailwayStation().equals(retrievedRecord.getRailwayStation())
    );
    trainDao.deleteTrainById(newRecord.getId());
  }

  @Test
  void updateTrain_ExistingTrain_RetrievedRecordIsUpdated() {
    trainDao.saveTrain((new TrainDB(4,"fgp710","France","c80","red",50,driver,"Cairo Railways")));
    TrainDB ExistingTrain =  trainDao.readTrainById(4);
    TrainDB updates = new TrainDB(4,"sqp710","Germany","888","White",100,driver,"Luxor Railways");
    trainDao.updateTrain(updates);
    TrainDB updatedTrain = trainDao.readTrainById(4);
    assertTrue(ExistingTrain.getId() == updatedTrain.getId() &&
        !ExistingTrain.getLicense().equals(updatedTrain.getLicense()) &&
        !ExistingTrain.getManifacCountry().equals(updatedTrain.getManifacCountry()) &&
        !ExistingTrain.getModel().equals(updatedTrain.getModel()) &&
        !ExistingTrain.getColour().equals(updatedTrain.getColour()) &&
        ExistingTrain.getNoOfSeats() != updatedTrain.getNoOfSeats() &&
        !ExistingTrain.getRailwayStation().equals(updatedTrain.getRailwayStation())
    );
    trainDao.deleteTrainById(ExistingTrain.getId());
  }

  @Test
  void readAllTrains_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<TrainDB> allRecords = new ArrayList<>(trainDao.readAllTrains());
    assertTrue(allRecords.size() > 0);
  }

  @Test
  void deleteTrainById_ExistingTrain_GettingNullObjectAfterDelete() {
    trainDao.saveTrain((new TrainDB(5,"fgp710","France","c80","red",50,driver,"Cairo Railways")));
    trainDao.deleteTrainById(5);
    assertNull(trainDao.readTrainById(5));
  }
}