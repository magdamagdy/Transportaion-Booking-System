package REST_WebServices.Services.TripService;

import DB_Configuration.Aerospike;
import Models.Person.DB.UserDB;
import Models.Trip.DB.TrainTripDB;
import Models.Trip.DTO.TrainTripDTO;
import Models.Trip.MapperInterfaces.TrainTripMapper;
import Models.Vehicle.DB.TrainDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainTripService {
    Aerospike aerospike = new Aerospike();

    public void AddTrainTrip(TrainTripDTO trainTrip) {
        TrainTripDB trainTripDB = TrainTripMapper.INSTANCE.TrainTripDtoToTrainTripDb(trainTrip);
        TrainDB train = aerospike.mapper.read(TrainDB.class, trainTrip.getRefTrainId());
        UserDB user = aerospike.mapper.read(UserDB.class, trainTrip.getRefUserId());
        trainTripDB.setTrain(train);
        trainTripDB.setUser(user);
        aerospike.mapper.save(trainTripDB);

        //add the trip to the user traintrip list
        if (user.getTrain_Trips() !=null) {
            //get user list of trips
            List<TrainTripDB> trainTrips = new ArrayList<>(user.getTrain_Trips());

            for ( TrainTripDB i : trainTrips) {
                if (i.getId() == trainTripDB.getId()){
                    return; //if the trip already found don't added to the list again
                }
            }
            //if trip not found add it
            trainTrips.add(trainTripDB);
            user.setTrain_Trips(trainTrips);
        }
        else {
            List<TrainTripDB> trainTrips = Arrays.asList(trainTripDB);
            user.setTrain_Trips(trainTrips);
        }
        aerospike.mapper.save(user);
    }

    public String UpdateTrainTrip(TrainTripDTO trainTrip){
        TrainTripDB trainTripDB = TrainTripMapper.INSTANCE.TrainTripDtoToTrainTripDb(trainTrip);
        if ((aerospike.mapper.read(TrainTripDB.class, trainTrip.getId()) != null)) {
            aerospike.mapper.update(trainTripDB,"date", "seat_no","trainClass");
            return "updated";
        }
        else {
            return "not found";
        }
    }
}
