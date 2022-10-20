package Models.Trip.DB;

import Models.Vehicle.DB.BusDB;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;

@AerospikeRecord(namespace="test", set="busTrip")
public class BusTripDB extends TripDB {

    @AerospikeReference
    private BusDB bus;


    //setter & getter
    public BusDB getBus() {
        return bus;
    }

    public void setBus(BusDB bus) {
        this.bus = bus;
    }
}
