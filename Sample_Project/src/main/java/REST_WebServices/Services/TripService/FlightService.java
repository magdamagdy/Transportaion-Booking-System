package REST_WebServices.Services.TripService;

import DB_Configuration.Aerospike;
import Models.Person.DB.UserDB;
import Models.Trip.DB.FlightDB;
import Models.Trip.DTO.FlightDTO;
import Models.Trip.MapperInterfaces.FlightMapper;
import Models.Vehicle.DB.PlaneDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FlightService {
    Aerospike aerospike = new Aerospike();

    public void AddFlight(FlightDTO flight){

        // mapper
        FlightDB flightDB = FlightMapper.INSTANCE.FlightDtoToFlightDb(flight);
        PlaneDB plane = aerospike.mapper.read(PlaneDB.class, flight.getRefPlaneId());
        UserDB user = aerospike.mapper.read(UserDB.class, flight.getRefUserId());
        flightDB.setPlane(plane);
        flightDB.setUser(user);
        aerospike.mapper.save(flightDB);

        //add the flight to the user flights list
        if (user.getFlights_() !=null) {
            //get user list of trips
            List<FlightDB> flights = new ArrayList<>(user.getFlights_());

            for ( FlightDB i : flights) {
                if (i.getId() == flightDB.getId()){
                    return; //if the flight already found don't added to the list again
                }
            }
            //if flight not found add it
            flights.add(flightDB);
            user.setFlights_(flights);
        }
        else {
            List<FlightDB> flights = Arrays.asList(flightDB);
            user.setFlights_(flights);
        }
        aerospike.mapper.save(user);
    }

    public String UpdateFlight(FlightDTO flight){
        FlightDB flightDB = FlightMapper.INSTANCE.FlightDtoToFlightDb(flight);
        if ((aerospike.mapper.read(FlightDB.class, flight.getId()) != null)) {
            aerospike.mapper.update(flightDB,"date", "seat_no","trainClass");
            return "updated";
        }
        else {
            return "not found";
        }
    }
}
