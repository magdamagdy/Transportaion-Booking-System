package com.exalt.transportationbookingsystem.controller.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import com.exalt.transportationbookingsystem.service.soap.PersonSoapService;
import com.exalt.transportationbookingsystem.service.soap.personSoapServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService
public class personController {

  private final String notFoundWarningMsg = "Object not found when searching by id";
  PersonSoapService personService = new personSoapServiceImpl();
  private static final Logger LOGGER = LoggerFactory.getLogger(personController.class);

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

  @WebMethod
  public List<UserDTO> getAllUsers(){
    return personService.getAllUsers();
  }

  @WebMethod
  public List<DriverDTO> getAllDrivers(){
    return personService.getAllDrivers();
  }
}
