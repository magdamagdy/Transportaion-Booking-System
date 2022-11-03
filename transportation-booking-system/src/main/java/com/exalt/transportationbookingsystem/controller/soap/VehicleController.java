package com.exalt.transportationbookingsystem.controller.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import com.exalt.transportationbookingsystem.service.soap.VehicleSoapService;
import com.exalt.transportationbookingsystem.service.soap.VehicleSoapServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Vehicle controller.
 */
@WebService
public class VehicleController {

  private final String notFoundWarningMsg = "Object not found when searching by id";
  private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);
  /**
   * The Vehicle service.
   */
  VehicleSoapService vehicleService = new VehicleSoapServiceImpl();

  /**
   * Get bus by id object.
   *
   * @param id the id
   * @return the object
   */
  @WebMethod
  public Object getBusById(int id){
    try {
      return vehicleService.getBusById(id);
    }
    catch (NotFoundException e)
    {
      LOGGER.warn(notFoundWarningMsg);
      return e.getMessage();
    }
  }

  /**
   * Get train by id object.
   *
   * @param id the id
   * @return the object
   */
  @WebMethod
  public Object getTrainById(int id){
    try {
      return vehicleService.getTrainById(id);
    }
    catch (NotFoundException e)
    {
      LOGGER.warn(notFoundWarningMsg);
      return e.getMessage();
    }
  }

  /**
   * Get plane by id object.
   *
   * @param id the id
   * @return the object
   */
  @WebMethod
  public Object getPlaneById(int id){
    try {
      return vehicleService.getPlaneById(id);
    }
    catch (NotFoundException e)
    {
      LOGGER.warn(notFoundWarningMsg);
      return e.getMessage();
    }
  }

  /**
   * Get all buses list.
   *
   * @return the list
   */
  @WebMethod
  public List<BusDTO> getAllBuses(){
    return vehicleService.getAllBuses();
  }

  /**
   * Get all trains list.
   *
   * @return the list
   */
  @WebMethod
  public List<TrainDTO> getAllTrains(){
    return vehicleService.getAllTrains();
  }

  /**
   * Get all planes list.
   *
   * @return the list
   */
  @WebMethod
  public List<PlaneDTO> getAllPlanes(){
    return vehicleService.getAllPlanes();
  }
}
