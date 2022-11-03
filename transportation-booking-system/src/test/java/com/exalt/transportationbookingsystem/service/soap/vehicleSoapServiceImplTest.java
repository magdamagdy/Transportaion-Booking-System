package com.exalt.transportationbookingsystem.service.soap;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class vehicleSoapServiceImplTest {

  VehicleSoapService vehicleSoapService = new vehicleSoapServiceImpl();
  @Test
  void getBusById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          vehicleSoapService.getBusById(30);
        });
  }

  @Test
  void getTrainById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          vehicleSoapService.getTrainById(30);
        });
  }

  @Test
  void getPlaneById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          vehicleSoapService.getPlaneById(30);
        });
  }

  @Test
  void getAllBuses_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<BusDTO> AllBuses = new ArrayList<>(vehicleSoapService.getAllBuses());
    assertTrue(AllBuses.size() > 0);
  }

  @Test
  void getAllTrains_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<TrainDTO> AllTrains = new ArrayList<>(vehicleSoapService.getAllTrains());
    assertTrue(AllTrains.size() > 0);
  }

  @Test
  void getAllPlanes_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<PlaneDTO> AllPlanes = new ArrayList<>(vehicleSoapService.getAllPlanes());
    assertTrue(AllPlanes.size() > 0);
  }
}