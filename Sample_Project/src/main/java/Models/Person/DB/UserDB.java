package Models.Person.DB;

import Models.Trip.DB.BusTripDB;
import Models.Trip.DB.FlightDB;
import Models.Trip.DB.TrainTripDB;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;

import java.util.ArrayList;
import java.util.List;

@AerospikeRecord(namespace="test", set="user")
public class UserDB extends PersonDB {


    @AerospikeReference
    private List<BusTripDB> Bus_Trips;

    @AerospikeReference
    private List<TrainTripDB> Train_Trips;

    @AerospikeReference
    private List<FlightDB> flights_;


    //getters & setters


    public List<BusTripDB> getBus_Trips() {
        return Bus_Trips;
    }

    public void setBus_Trips(List<BusTripDB> bus_Trips) {
        Bus_Trips = bus_Trips;
    }

    public List<TrainTripDB> getTrain_Trips() {
        return Train_Trips;
    }

    public void setTrain_Trips(List<TrainTripDB> train_Trips) {
        Train_Trips = train_Trips;
    }

    public List<FlightDB> getFlights_() {
        return flights_;
    }

    public void setFlights_(List<FlightDB> flights_) {
        this.flights_ = flights_;
    }
}
