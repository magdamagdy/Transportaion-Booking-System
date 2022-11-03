package com.exalt.transportationbookingsystem.service.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import java.util.List;

/**
 * The interface Person soap service.
 */
public interface PersonSoapService {

  /**
   * Gets user by id.
   *
   * @param id the id
   * @return the user by id
   * @throws NotFoundException the not found exception
   */
  UserDTO getUserById(int id) throws NotFoundException;

  /**
   * Gets driver by id.
   *
   * @param id the id
   * @return the driver by id
   * @throws NotFoundException the not found exception
   */
  DriverDTO getDriverById(int id) throws NotFoundException;

  /**
   * Gets all users.
   *
   * @return the all users
   */
  List<UserDTO> getAllUsers();

  /**
   * Gets all drivers.
   *
   * @return the all drivers
   */
  List<DriverDTO> getAllDrivers();

}
