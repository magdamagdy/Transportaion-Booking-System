package com.exalt.transportationbookingsystem.models.trip.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;

/**
 * The type Train trip db.
 */
@AerospikeRecord(namespace="test", set="trainTrip")
public class TrainTripDB extends TripDB {

    private String trainClass;

    @AerospikeReference
    private TrainDB train;

    /**
     * Gets train class.
     *
     * @return the train class
     */
    public String getTrainClass() {
        return trainClass;
    }

    /**
     * Sets train class.
     *
     * @param trainClass the train class
     */
    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    /**
     * Gets train.
     *
     * @return the train
     */
    public TrainDB getTrain() {
        return train;
    }

    /**
     * Sets train.
     *
     * @param train the train
     */
    public void setTrain(TrainDB train) {
        this.train = train;
    }

    /**
     * Instantiates a new Train trip db.
     *
     * @param id            the id
     * @param date          the date
     * @param seatNo        the seat no
     * @param departureTime the departure time
     * @param arrivalTime   the arrival time
     * @param startLocation the start location
     * @param destination   the destination
     * @param user          the user
     * @param trainClass    the train class
     * @param train         the train
     */
    public TrainTripDB(int id, String date, int seatNo, String departureTime, String arrivalTime,
        String startLocation, String destination, UserDB user, String trainClass, TrainDB train) {
        super(id, date, seatNo, departureTime, arrivalTime, startLocation, destination, user);
        this.trainClass = trainClass;
        this.train = train;
    }
}
