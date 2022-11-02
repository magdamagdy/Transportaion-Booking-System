package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import java.util.List;

public interface PlaneDao {
  void savePlane(PlaneDB plane);
  void updatePlane(PlaneDB plane);
  PlaneDB readPlaneById(int id);
  List<PlaneDB> readAllPlanes();
  void deletePlaneById(int id);
}
