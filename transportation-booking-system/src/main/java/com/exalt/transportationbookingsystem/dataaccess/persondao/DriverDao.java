package com.exalt.transportationbookingsystem.dataaccess.persondao;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import java.util.List;

public interface DriverDao {
  void saveDriver(DriverDB driver);
  void updateDriver(DriverDB driver);
  DriverDB readDriverById(int id);
  List<DriverDB> readAllDrivers();
  void deleteDriverById(int id);
}
