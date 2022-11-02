package com.exalt.transportationbookingsystem.dataaccess.tripdao;

import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import java.util.List;

public interface BusTripDao {

  void saveBusTrip(BusTripDB trip);
  void updateBusTrip(BusTripDB trip);
  BusTripDB readBusTripById(int id);
  List<BusTripDB> readAllBusTrips();
  void deleteBusTripById(int id);
}
