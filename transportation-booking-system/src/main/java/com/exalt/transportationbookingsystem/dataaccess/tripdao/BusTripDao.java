package com.exalt.transportationbookingsystem.dataaccess.tripdao;

import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import java.util.List;

/**
 * The interface Bus trip dao.
 */
public interface BusTripDao {

  /**
   * Save bus trip.
   *
   * @param trip the trip
   */
  void saveBusTrip(BusTripDB trip);

  /**
   * Update bus trip.
   *
   * @param trip the trip
   */
  void updateBusTrip(BusTripDB trip);

  /**
   * Read bus trip by id bus trip db.
   *
   * @param id the id
   * @return the bus trip db
   */
  BusTripDB readBusTripById(int id);

  /**
   * Read all bus trips list.
   *
   * @return the list of all BusTrips
   */
  List<BusTripDB> readAllBusTrips();

  /**
   * Delete bus trip by id.
   *
   * @param id the id
   */
  void deleteBusTripById(int id);
}
