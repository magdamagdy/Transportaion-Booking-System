package REST_WebServices.Services.TripService;

import DB_Configuration.Aerospike;
import Models.Person.DB.UserDB;
import Models.Trip.DB.BusTripDB;
import Models.Trip.DTO.BusTripDTO;
import Models.Trip.MapperInterfaces.BusTripMapper;
import Models.Vehicle.DB.BusDB;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusTripService {

    Aerospike aerospike = new Aerospike();

    public void AddBusTrip(BusTripDTO busTrip){
        BusTripDB busTripDB = BusTripMapper.INSTANCE.BusTripDtoToBusTripDb(busTrip);
        BusDB bus = aerospike.mapper.read(BusDB.class, busTrip.getRefBusId());
        UserDB user = aerospike.mapper.read(UserDB.class, busTrip.getRefUserId());
        busTripDB.setBus(bus);
        busTripDB.setUser(user);
        aerospike.mapper.save(busTripDB);
        //add the trip to the user bustrip list
        if (user.getBus_Trips() !=null) {
            //get user list of trips
            List<BusTripDB> busTrips = new ArrayList<>(user.getBus_Trips());

            for ( BusTripDB i : busTrips) {
                if (i.getId() == busTripDB.getId()){
                    return; //if the trip already found don't added to the list again
                }
            }
            //if trip not found add it
            busTrips.add(busTripDB);
            user.setBus_Trips(busTrips);
        }
        else {
            List<BusTripDB> busTrips = Arrays.asList(busTripDB);
            user.setBus_Trips(busTrips);
        }
        aerospike.mapper.save(user);
    }

    public String UpdateBusTrip(BusTripDTO busTrip){
        BusTripDB busTripDB = BusTripMapper.INSTANCE.BusTripDtoToBusTripDb(busTrip);
        if ((aerospike.mapper.read(BusTripDB.class, busTrip.getId()) != null)) {
            aerospike.mapper.update(busTripDB,"date", "seat_no");
            return "updated";
        }
        else {
            return "not found";
        }
    }
}
