package Models.Vehicle.DB;

import com.aerospike.mapper.annotations.AerospikeRecord;

@AerospikeRecord(namespace="test", set="plane")
public class PlaneDB extends VehicleDB {
    private String airport;
    private String airlines;


    //getters & setters
    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }


}
