package com.exalt.transportationbookingsystem.service.rest.personservice;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import org.junit.jupiter.api.Test;

class userServiceImplTest {

  UserService userService = new userServiceImpl();
  @Test
  void addUser_NullValue_ThrowsNullValueException() {
    UserDTO user = new UserDTO();
    assertThrows(NullValueException.class,
        ()-> {
          userService.addUser(user);
        });
  }

  @Test
  void addUser_NewUser_NewRecordDtoIsConsistentWithReturnedRecord() throws NullValueException {
    UserDTO newRecord = new UserDTO(4,40,"male","01299663300","user@gmail.com");
    UserDTO retrievedRecord = userService.addUser(newRecord);
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getAge() == retrievedRecord.getAge() &&
        newRecord.getGender().equals(retrievedRecord.getGender()) &&
        newRecord.getPhone().equals(retrievedRecord.getPhone()) &&
        newRecord.getEmail().equals(retrievedRecord.getEmail())
    );
  }

  @Test
  void updateUser_NullValue_ThrowsNullValueException() {
    UserDTO user = new UserDTO();
    assertThrows(NullValueException.class,
        ()-> {
          userService.addUser(user);
        });
  }

  @Test
  void updateUser_NotFoundId_ThrowsNotFoundException() {
    UserDTO user = new UserDTO(20,40,"male","01299663300","user@gmail.com");
    assertThrows(NotFoundException.class,
        ()-> {
          userService.updateUser(user);
        });
  }

  @Test
  void updateUser_ExistingUser_UserDataUpdated() throws NullValueException, NotFoundException {
    UserDTO existingUser = new UserDTO(4,50,"male","01248936711","uaserdto@gmail.com");
    UserDTO updates = new UserDTO(4,45,"female","01296736711","user@gmail.com");
    UserDTO updatedUser = userService.updateUser(updates);
    assertTrue(existingUser.getId() == updatedUser.getId() &&
        existingUser.getAge() != updatedUser.getAge() &&
        !existingUser.getGender().equals(updatedUser.getGender()) &&
        !existingUser.getPhone().equals(updatedUser.getPhone()) &&
        !existingUser.getEmail().equals(updatedUser.getEmail())
    );
  }

}