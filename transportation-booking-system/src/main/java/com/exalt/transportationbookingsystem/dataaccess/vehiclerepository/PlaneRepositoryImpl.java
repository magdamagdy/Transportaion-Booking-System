package com.exalt.transportationbookingsystem.dataaccess.vehiclerepository;

import com.exalt.transportationbookingsystem.dbconfiguration.Database;
import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import java.util.List;

public class PlaneRepositoryImpl implements PlaneRepository {

  private final String license = "license";
  private final String manifacCountry = "manifacCountry";
  private final String model = "model";
  private final String colour = "colour";
  private final String noOfSeats ="noOfSeats";
  private final String airport = "airport";
  private final String airlines = "airlines";

  /**
   * The Aerospike Instance.
   */
  Database aerospike = Database.getInstance();

  @Override
  public void savePlane(PlaneDB plane){
      aerospike.mapper.save(plane);
  }

  @Override
  public void updatePlane(PlaneDB plane){
      aerospike.mapper.update(plane,license, manifacCountry,model,colour,noOfSeats,airport,airlines);
  }

  @Override
  public PlaneDB readPlaneById(int id){
    return aerospike.mapper.read(PlaneDB.class, id);
  }

  @Override
  public List<PlaneDB> readAllPlanes(){
    return aerospike.mapper.scan(PlaneDB.class);
  }

  @Override
  public void deletePlaneById(int id){
      aerospike.mapper.delete(PlaneDB.class, id);
  }


}
