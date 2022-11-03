package com.exalt.transportationbookingsystem.controller.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.service.soap.TripSoapService;
import com.exalt.transportationbookingsystem.service.soap.TripSoapServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Trip controller.
 */
@WebService
public class TripController {

  private final String notFoundWarningMsg = "Object not found when searching by id";
  private static final Logger LOGGER = LoggerFactory.getLogger(TripController.class);

  /**
   * The Trip service.
   */
  TripSoapService tripService = new TripSoapServiceImpl();

  /**
   * Get bus trip by id object.
   *
   * @param id the id
   * @return the object
   */
  @WebMethod
  public Object getBusTripById(int id){
    try{
      return tripService.getBusTripById(id);
    }
    catch (NotFoundException e)
    {
      LOGGER.warn(notFoundWarningMsg);
      return e.getMessage();
    }
  }

  /**
   * Get train trip by id object.
   *
   * @param id the id
   * @return the object
   */
  @WebMethod
  public Object getTrainTripById(int id){
    try {
      return tripService.getTrainTripById(id);
    }
    catch (NotFoundException e)
    {
      LOGGER.warn(notFoundWarningMsg);
      return e.getMessage();
    }
  }

  /**
   * Get flight by id object.
   *
   * @param id the id
   * @return the object
   */
  @WebMethod
  public Object getFlightById(int id){
    try{
      return tripService.getFlightById(id);
    }
    catch (NotFoundException e)
    {
      LOGGER.warn(notFoundWarningMsg);
      return e.getMessage();
    }
  }

  /**
   * Get all trips by user id object.
   * Takes user id and returns all trips booked by this user
   * @param id the id
   * @return the object
   */
  @WebMethod
  public Object getAllTripsByUserId (int id){
    try {
      return tripService.getAllTripsByUserId(id);
    }
    catch (NotFoundException e)
    {
      LOGGER.warn(notFoundWarningMsg);
      return e.getMessage();
    }
  }
}
