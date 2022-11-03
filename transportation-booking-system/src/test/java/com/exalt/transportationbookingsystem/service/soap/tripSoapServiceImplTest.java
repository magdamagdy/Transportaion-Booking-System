package com.exalt.transportationbookingsystem.service.soap;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.dto.UserTripListsDTO;
import org.junit.jupiter.api.Test;

/**
 * The type Trip soap service impl test.
 */
class tripSoapServiceImplTest {

  /**
   * The Trip soap service.
   */
  TripSoapService tripSoapService = new tripSoapServiceImpl();

  /**
   * Gets bus trip by id not found id throws not found exception.
   */
  @Test
  void getBusTripById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          tripSoapService.getBusTripById(30);
        });
  }

  /**
   * Gets train trip by id not found id throws not found exception.
   */
  @Test
  void getTrainTripById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          tripSoapService.getTrainTripById(30);
        });
  }

  /**
   * Gets flight by id not found id throws not found exception.
   */
  @Test
  void getFlightById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          tripSoapService.getFlightById(30);
        });
  }

  /**
   * Gets all trips by user id not found id throws not found exception.
   */
  @Test
  void getAllTripsByUserId_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          tripSoapService.getAllTripsByUserId(20);
        });
  }

  /**
   * Gets all trips by user id existing user with existing trips not null user trip lists dto.
   *
   * @throws NotFoundException the not found exception
   */
  @Test
  void getAllTripsByUserId_ExistingUserWithExistingTrips_NotNullUserTripListsDTO()
      throws NotFoundException {
    UserTripListsDTO allTrips = tripSoapService.getAllTripsByUserId(1);
    assertNotNull(allTrips);
  }
}