package Models.Trip.DB;

import Models.Vehicle.DB.TrainDB;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;

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
}
