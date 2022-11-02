package com.exalt.transportationbookingsystem.service.soap;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import java.util.List;

public interface VehicleSoapService {

  BusDTO getBusById(int id) throws NotFoundException;
  TrainDTO getTrainById(int id) throws NotFoundException;
  PlaneDTO getPlaneById(int id) throws NotFoundException;
  List<BusDTO> getAllBuses();
  List<TrainDTO> getAllTrains();
  List<PlaneDTO> getAllPlanes();
}
