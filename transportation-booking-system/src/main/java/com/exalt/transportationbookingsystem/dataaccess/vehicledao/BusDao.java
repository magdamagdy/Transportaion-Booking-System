package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import java.util.List;

public interface BusDao {

  void saveBus(BusDB bus);
  void updateBus(BusDB bus);
  BusDB readBusById(int id);
  List<BusDB> readAllBuses();
  void deleteBusById(int id);

}
