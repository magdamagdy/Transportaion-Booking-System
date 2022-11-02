package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;

public interface TrainService {
  TrainDTO addTrain(TrainDTO train) throws NullValueException;
  TrainDTO updateTrain(TrainDTO train) throws NullValueException, NotFoundException;

}
