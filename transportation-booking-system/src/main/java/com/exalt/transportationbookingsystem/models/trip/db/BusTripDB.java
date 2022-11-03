package com.exalt.transportationbookingsystem.models.trip.db;

import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;

/**
 * The type Bus trip db.
 */
@AerospikeRecord(namespace="test", set="busTrip")
public class BusTripDB extends TripDB {

    @AerospikeReference
    private BusDB bus;

    /**
     * Gets bus.
     *
     * @return the bus
     */
    public BusDB getBus() {
        return bus;
    }

    /**
     * Sets bus.
     *
     * @param bus the bus
     */
    public void setBus(BusDB bus) {
        this.bus = bus;
    }

    /**
     * Instantiates a new Bus trip db.
     *
     * @param id            the id
     * @param date          the date
     * @param seatNo        the seat no
     * @param departureTime the departure time
     * @param arrivalTime   the arrival time
     * @param startLocation the start location
     * @param destination   the destination
     * @param user          the user
     * @param bus           the bus
     */
    public BusTripDB(int id, String date, int seatNo, String departureTime, String arrivalTime,
        String startLocation, String destination, UserDB user, BusDB bus) {
        super(id, date, seatNo, departureTime, arrivalTime, startLocation, destination, user);
        this.bus = bus;
    }
}
