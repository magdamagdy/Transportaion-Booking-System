package com.exalt.transportationbookingsystem.models.trip.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;

/**
 * The type Flight db.
 */
@AerospikeRecord(namespace="test", set="flight")
public class FlightDB extends TripDB {

    private String flightClass;

    @AerospikeReference
    private PlaneDB plane;

    /**
     * Gets flight class.
     *
     * @return the flight class
     */
    public String getFlightClass() {
        return flightClass;
    }

    /**
     * Sets flight class.
     *
     * @param flightClass the flight class
     */
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    /**
     * Gets plane.
     *
     * @return the plane
     */
    public PlaneDB getPlane() {
        return plane;
    }

    /**
     * Sets plane.
     *
     * @param plane the plane
     */
    public void setPlane(PlaneDB plane) {
        this.plane = plane;
    }


    /**
     * Instantiates a new Flight db.
     *
     * @param id            the id
     * @param date          the date
     * @param seatNo        the seat no
     * @param departureTime the departure time
     * @param arrivalTime   the arrival time
     * @param startLocation the start location
     * @param destination   the destination
     * @param user          the user
     * @param flightClass   the flight class
     * @param plane         the plane
     */
    public FlightDB(int id, String date, int seatNo, String departureTime, String arrivalTime,
        String startLocation, String destination,
        UserDB user, String flightClass,
        PlaneDB plane) {
        super(id, date, seatNo, departureTime, arrivalTime, startLocation, destination, user);
        this.flightClass = flightClass;
        this.plane = plane;
    }
}
