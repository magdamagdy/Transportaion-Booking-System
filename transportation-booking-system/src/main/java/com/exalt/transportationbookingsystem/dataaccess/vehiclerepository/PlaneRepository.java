package com.exalt.transportationbookingsystem.dataaccess.vehiclerepository;

import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import java.util.List;

/**
 * The interface Plane dao.
 */
public interface PlaneRepository {

  /**
   * Save plane.
   *
   * @param plane the plane
   */
  void savePlane(PlaneDB plane);

  /**
   * Update plane.
   *
   * @param plane the plane
   */
  void updatePlane(PlaneDB plane);

  /**
   * Read plane by id plane db.
   *
   * @param id the id
   * @return the plane db
   */
  PlaneDB readPlaneById(int id);

  /**
   * Read all planes list.
   *
   * @return the list of all Planes
   */
  List<PlaneDB> readAllPlanes();

  /**
   * Delete plane by id.
   *
   * @param id the id
   */
  void deletePlaneById(int id);
}
