package com.exalt.transportationbookingsystem.service.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import java.util.List;

public interface PersonSoapService {

  UserDTO getUserById(int id) throws NotFoundException;
  DriverDTO getDriverById(int id) throws NotFoundException;

  List<UserDTO> getAllUsers();
  List<DriverDTO> getAllDrivers();

}
