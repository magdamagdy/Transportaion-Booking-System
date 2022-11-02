package com.exalt.transportationbookingsystem.controller.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import com.exalt.transportationbookingsystem.service.soap.VehicleSoapService;
import com.exalt.transportationbookingsystem.service.soap.vehicleSoapServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService
public class vehicleController {

  private final String notFoundWarningMsg = "Object not found when searching by id";
  private static final Logger LOGGER = LoggerFactory.getLogger(vehicleController.class);
  VehicleSoapService vehicleService = new vehicleSoapServiceImpl();

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

  @WebMethod
  public List<BusDTO> getAllBuses(){
    return vehicleService.getAllBuses();
  }

  @WebMethod
  public List<TrainDTO> getAllTrains(){
    return vehicleService.getAllTrains();
  }

  @WebMethod
  public List<PlaneDTO> getAllPlanes(){
    return vehicleService.getAllPlanes();
  }
}
