package com.exalt.transportationbookingsystem.service.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import java.util.List;

/**
 * The interface Vehicle soap service.
 */
public interface VehicleSoapService {

  /**
   * Gets bus by id.
   *
   * @param id the id
   * @return the bus by id
   * @throws NotFoundException the not found exception
   */
  BusDTO getBusById(int id) throws NotFoundException;

  /**
   * Gets train by id.
   *
   * @param id the id
   * @return the train by id
   * @throws NotFoundException the not found exception
   */
  TrainDTO getTrainById(int id) throws NotFoundException;

  /**
   * Gets plane by id.
   *
   * @param id the id
   * @return the plane by id
   * @throws NotFoundException the not found exception
   */
  PlaneDTO getPlaneById(int id) throws NotFoundException;

  /**
   * Gets all buses.
   *
   * @return the all buses
   */
  List<BusDTO> getAllBuses();

  /**
   * Gets all trains.
   *
   * @return the all trains
   */
  List<TrainDTO> getAllTrains();

  /**
   * Gets all planes.
   *
   * @return the all planes
   */
  List<PlaneDTO> getAllPlanes();
}
