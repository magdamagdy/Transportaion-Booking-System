package SOAP_WebServices.Client;

import DB_Configuration.Aerospike;
import Models.Person.DB.DriverDB;
import Models.Person.DB.UserDB;
import Models.Trip.DB.BusTripDB;
import Models.Trip.DB.FlightDB;
import Models.Trip.DB.TrainTripDB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class PersonSoapClientService {

    Aerospike aerospike = new Aerospike();

    @WebMethod
    public String DeleteUserById (int id){
        //Cascade delete
        //Delete all trips related to this user then delete the user itself

        List<BusTripDB> AllBusTrips = new ArrayList<>(aerospike.mapper.scan(BusTripDB.class));
        List<TrainTripDB> AllTrainTrips = new ArrayList<>(aerospike.mapper.scan(TrainTripDB.class));
        List<FlightDB> AllFlights = new ArrayList<>(aerospike.mapper.scan(FlightDB.class));

        for (BusTripDB i: AllBusTrips) {
            if(i.getUser().getId() == id)
            {
                aerospike.mapper.delete(BusTripDB.class, i.getId());
            }
        }
        for (TrainTripDB i: AllTrainTrips) {
            if(i.getUser().getId() == id)
            {
                aerospike.mapper.delete(TrainTripDB.class, i.getId());
            }
        }
        for (FlightDB i: AllFlights) {
            if(i.getUser().getId() == id)
            {
                aerospike.mapper.delete(FlightDB.class, i.getId());
            }
        }

        aerospike.mapper.delete(UserDB.class, id);
        return "Deleted";
    }

    @WebMethod
    public String DeletDriverById(int id){
        aerospike.mapper.delete(DriverDB.class, id);
        return "Deleted";
    }

}


