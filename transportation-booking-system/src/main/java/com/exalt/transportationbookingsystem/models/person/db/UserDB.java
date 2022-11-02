package com.exalt.transportationbookingsystem.models.person.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;

import java.util.List;

@AerospikeRecord(namespace="test", set="user")
public class UserDB extends PersonDB {


    @AerospikeReference
    private List<BusTripDB> busTrips;

    @AerospikeReference
    private List<TrainTripDB> trainTrips;

    @AerospikeReference
    private List<FlightDB> flights;


    //getters & setters

    public List<BusTripDB> getBusTrips() {
        return busTrips;
    }

    public void setBusTrips(List<BusTripDB> busTrips) {
        this.busTrips = busTrips;
    }

    public List<TrainTripDB> getTrainTrips() {
        return trainTrips;
    }

    public void setTrainTrips(List<TrainTripDB> trainTrips) {
        this.trainTrips = trainTrips;
    }

    public List<FlightDB> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDB> flights) {
        this.flights = flights;
    }

    //constructor

    public UserDB(int id, int age, String gender, String phone, String email) {
        super(id, age, gender, phone, email);
    }
}
