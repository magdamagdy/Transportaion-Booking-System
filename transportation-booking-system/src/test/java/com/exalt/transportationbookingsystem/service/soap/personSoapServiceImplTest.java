package com.exalt.transportationbookingsystem.service.soap;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class personSoapServiceImplTest {

  PersonSoapService personSoapService =new personSoapServiceImpl();
  @Test
  void getUserById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          personSoapService.getUserById(30);
        });
  }

  @Test
  void getDriverById_NotFoundId_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        ()-> {
          personSoapService.getDriverById(30);
        });
  }

  @Test
  void getAllUsers_ExistingRecords_NotNullListRetrieved() {
    List<UserDTO> allRecords = new ArrayList<>(personSoapService.getAllUsers());
    assertTrue(allRecords.size() > 0);
  }

  @Test
  void getAllDrivers_ExistingRecords_NotNullListRetrieved() {
    List<DriverDTO> allRecords = new ArrayList<>(personSoapService.getAllDrivers());
    assertTrue(allRecords.size() > 0);
  }
}