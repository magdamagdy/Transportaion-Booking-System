package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import java.util.List;

/**
 * The interface Bus dao.
 */
public interface BusDao {

  /**
   * Save bus.
   *
   * @param bus the bus
   */
  void saveBus(BusDB bus);

  /**
   * Update bus.
   *
   * @param bus the bus
   */
  void updateBus(BusDB bus);

  /**
   * Read bus by id bus db.
   *
   * @param id the id
   * @return the bus db
   */
  BusDB readBusById(int id);

  /**
   * Read all buses list.
   *
   * @return the list of all Buses
   */
  List<BusDB> readAllBuses();

  /**
   * Delete bus by id.
   *
   * @param id the id
   */
  void deleteBusById(int id);

}
