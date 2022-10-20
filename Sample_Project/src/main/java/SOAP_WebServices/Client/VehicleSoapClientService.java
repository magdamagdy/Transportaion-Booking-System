package SOAP_WebServices.Client;

import DB_Configuration.Aerospike;
import Models.Trip.DB.BusTripDB;
import Models.Trip.DB.FlightDB;
import Models.Trip.DB.TrainTripDB;
import Models.Vehicle.DB.BusDB;
import Models.Vehicle.DB.PlaneDB;
import Models.Vehicle.DB.TrainDB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService
public class VehicleSoapClientService {

    Aerospike aerospike = new Aerospike();

    @WebMethod
    public String DeleteBusById(int id){
        List<BusTripDB> AllTrips = new ArrayList<>(aerospike.mapper.scan(BusTripDB.class));
        for (BusTripDB i : AllTrips) {
            if (i.getBus().getId() == id){
                return "Restrict Delete";
            }
        }
        //else if bus not assigned to any trip delete it
        aerospike.mapper.delete(BusDB.class, id);
        return "Deleted";
    }

    @WebMethod
    public String DeleteTrainById(int id){
        List<TrainTripDB> AllTrips = new ArrayList<>(aerospike.mapper.scan(TrainTripDB.class));
        for (TrainTripDB i : AllTrips) {
            if (i.getTrain().getId() == id){
                return "Restrict Delete";
            }
        }
        //else if train not assigned to any trip delete it
        aerospike.mapper.delete(TrainDB.class, id);
        return "Deleted";
    }

    @WebMethod
    public String DeletePlaneById(int id){
        List<FlightDB> AllTrips = new ArrayList<>(aerospike.mapper.scan(FlightDB.class));
        for (FlightDB i : AllTrips) {
            if (i.getPlane().getId() == id){
                return "Restrict Delete";
            }
        }
        //else if plane not assigned to any flight delete it
        aerospike.mapper.delete(PlaneDB.class, id);
        return "Deleted";
    }
}
