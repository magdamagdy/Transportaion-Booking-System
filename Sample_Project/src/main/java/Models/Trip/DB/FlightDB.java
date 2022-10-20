package Models.Trip.DB;

import Models.Vehicle.DB.PlaneDB;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;

@AerospikeRecord(namespace="test", set="flight")
public class FlightDB extends TripDB {

    private String flightClass;

    @AerospikeReference
    private PlaneDB plane;


    //getters & setters
    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public PlaneDB getPlane() {
        return plane;
    }

    public void setPlane(PlaneDB plane) {
        this.plane = plane;
    }
}
