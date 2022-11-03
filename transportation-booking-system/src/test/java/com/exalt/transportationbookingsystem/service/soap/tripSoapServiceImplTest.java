package com.exalt.transportationbookingsystem.service.soap;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.dto.UserTripListsDTO;
import org.junit.jupiter.api.Test;

class tripSoapServiceImplTest {

  TripSoapService tripSoapService = new tripSoapServiceImpl();
  @Test
  void getBusTripById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          tripSoapService.getBusTripById(30);
        });
  }

  @Test
  void getTrainTripById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          tripSoapService.getTrainTripById(30);
        });
  }

  @Test
  void getFlightById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          tripSoapService.getFlightById(30);
        });
  }
  @Test
  void getAllTripsByUserId_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          tripSoapService.getAllTripsByUserId(20);
        });
  }

  @Test
  void getAllTripsByUserId_ExistingUserWithExistingTrips_NotNullUserTripListsDTO()
      throws NotFoundException {
    UserTripListsDTO allTrips = tripSoapService.getAllTripsByUserId(1);
    assertNotNull(allTrips);
  }
}