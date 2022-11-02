package com.exalt.transportationbookingsystem.service.rest.personservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;

public interface UserService {
  UserDTO addUser(UserDTO user) throws NullValueException;
  UserDTO updateUser(UserDTO user) throws NullValueException, NotFoundException;
}
