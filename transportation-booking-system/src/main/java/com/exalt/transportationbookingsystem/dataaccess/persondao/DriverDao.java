package com.exalt.transportationbookingsystem.dataaccess.persondao;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import java.util.List;

/**
 * The interface Driver dao.
 */
public interface DriverDao {

  /**
   * Save driver.
   *
   * @param driver the driver
   */
  void saveDriver(DriverDB driver);

  /**
   * Update driver.
   *
   * @param driver the driver
   */
  void updateDriver(DriverDB driver);

  /**
   * Read driver by id driver db.
   *
   * @param id the id
   * @return the driver db
   */
  DriverDB readDriverById(int id);

  /**
   * Read all drivers list.
   *
   * @return the list of all drivers
   */
  List<DriverDB> readAllDrivers();

  /**
   * Delete driver by id.
   *
   * @param id the id
   */
  void deleteDriverById(int id);
}
