package com.exalt.transportationbookingsystem.models.person.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;

import java.util.List;

/**
 * The type User db.
 */
@AerospikeRecord(namespace="test", set="user")
public class UserDB extends PersonDB {


    @AerospikeReference
    private List<BusTripDB> busTrips;

    @AerospikeReference
    private List<TrainTripDB> trainTrips;

    @AerospikeReference
    private List<FlightDB> flights;


    /**
     * Gets bus trips.
     *
     * @return the bus trips
     */
    public List<BusTripDB> getBusTrips() {
        return busTrips;
    }

    /**
     * Sets bus trips.
     *
     * @param busTrips the bus trips
     */
    public void setBusTrips(List<BusTripDB> busTrips) {
        this.busTrips = busTrips;
    }

    /**
     * Gets train trips.
     *
     * @return the train trips
     */
    public List<TrainTripDB> getTrainTrips() {
        return trainTrips;
    }

    /**
     * Sets train trips.
     *
     * @param trainTrips the train trips
     */
    public void setTrainTrips(List<TrainTripDB> trainTrips) {
        this.trainTrips = trainTrips;
    }

    /**
     * Gets flights.
     *
     * @return the flights
     */
    public List<FlightDB> getFlights() {
        return flights;
    }

    /**
     * Sets flights.
     *
     * @param flights the flights
     */
    public void setFlights(List<FlightDB> flights) {
        this.flights = flights;
    }


    /**
     * Instantiates a new User db.
     *
     * @param id     the id
     * @param age    the age
     * @param gender the gender
     * @param phone  the phone
     * @param email  the email
     */
    public UserDB(int id, int age, String gender, String phone, String email) {
        super(id, age, gender, phone, email);
    }
}
