package com.exalt.transportationbookingsystem.controller.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import com.exalt.transportationbookingsystem.service.soap.PersonSoapService;
import com.exalt.transportationbookingsystem.service.soap.PersonSoapServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Person controller.
 */
@WebService
public class PersonController {

  private final String notFoundWarningMsg = "Object not found when searching by id";
  /**
   * The Person service.
   */
  PersonSoapService personService = new PersonSoapServiceImpl();
  private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

  /**
   * Gets user by id.
   *
   * @param id the id
   * @return the user by id
   */
  @WebMethod
  public Object getUserById(int id) {
   try {
     return personService.getUserById(id);
   }
   catch (NotFoundException e)
   {

     return e.getMessage();
   }
  }

  /**
   * Get driver by id object.
   *
   * @param id the id
   * @return the object
   */
  @WebMethod
  public Object getDriverById(int id){
    try {
      return personService.getDriverById(id);
    }
    catch (NotFoundException e)
    {
      LOGGER.warn(notFoundWarningMsg);
      return e.getMessage();
    }
  }

  /**
   * Get all users list.
   *
   * @return the list
   */
  @WebMethod
  public List<UserDTO> getAllUsers(){
    return personService.getAllUsers();
  }

  /**
   * Get all drivers list.
   *
   * @return the list
   */
  @WebMethod
  public List<DriverDTO> getAllDrivers(){
    return personService.getAllDrivers();
  }
}
