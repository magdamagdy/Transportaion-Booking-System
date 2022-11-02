package com.exalt.transportationbookingsystem.models.trip.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;

@AerospikeRecord(namespace="test", set="trainTrip")
public class TrainTripDB extends TripDB {

    private String trainClass;

    @AerospikeReference
    private TrainDB train;


    //setters & getters
    public String getTrainClass() {
        return trainClass;
    }

    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    public TrainDB getTrain() {
        return train;
    }

    public void setTrain(TrainDB train) {
        this.train = train;
    }

    //constructor

    public TrainTripDB(int id, String date, int seatNo, String departureTime, String arrivalTime,
        String startLocation, String destination,
        UserDB user, String trainClass,
        TrainDB train) {
        super(id, date, seatNo, departureTime, arrivalTime, startLocation, destination, user);
        this.trainClass = trainClass;
        this.train = train;
    }
}
