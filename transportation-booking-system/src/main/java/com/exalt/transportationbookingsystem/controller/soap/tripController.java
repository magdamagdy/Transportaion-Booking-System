package com.exalt.transportationbookingsystem.controller.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.service.soap.TripSoapService;
import com.exalt.transportationbookingsystem.service.soap.tripSoapServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService
public class tripController {

  private final String notFoundWarningMsg = "Object not found when searching by id";
  private static final Logger LOGGER = LoggerFactory.getLogger(tripController.class);

  TripSoapService tripService = new tripSoapServiceImpl();

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
