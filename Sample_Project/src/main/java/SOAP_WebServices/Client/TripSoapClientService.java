package SOAP_WebServices.Client;

import DB_Configuration.Aerospike;
import Models.Trip.DB.BusTripDB;
import Models.Trip.DB.FlightDB;
import Models.Trip.DB.TrainTripDB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class TripSoapClientService {

    Aerospike aerospike = new Aerospike();

    @WebMethod
    public String DeleteBusTripById (int id){
        aerospike.mapper.delete(BusTripDB.class, id);
        return "Deleted";
    }

    @WebMethod
    public String DeleteTrainTripById (int id){
        aerospike.mapper.delete(TrainTripDB.class, id);
        return "Deleted";
    }

    @WebMethod
    public String DeleteFlightById (int id){
        aerospike.mapper.delete(FlightDB.class, id);
        return "Deleted";
    }

}
