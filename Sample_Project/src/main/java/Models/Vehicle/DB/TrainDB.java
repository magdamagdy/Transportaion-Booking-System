package Models.Vehicle.DB;

import com.aerospike.mapper.annotations.AerospikeRecord;

@AerospikeRecord(namespace="test", set="train")
public class TrainDB extends VehicleDB {
    private String railwayStation;

    //getters & setters
    public String getRailwayStation() {
        return railwayStation;
    }

    public void setRailwayStation(String railwayStation) {
        this.railwayStation = railwayStation;
    }


}
