package com.exalt.transportationbookingsystem.service.rest.personservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;

/**
 * The interface User service.
 */
public interface UserService {

  /**
   * Add user user dto.
   *
   * @param user the user
   * @return the user dto
   * @throws NullValueException the null value exception
   */
  UserDTO addUser(UserDTO user) throws NullValueException;

  /**
   * Update user user dto.
   *
   * @param user the user
   * @return the user dto
   * @throws NullValueException the null value exception
   * @throws NotFoundException  the not found exception
   */
  UserDTO updateUser(UserDTO user) throws NullValueException, NotFoundException;
}
