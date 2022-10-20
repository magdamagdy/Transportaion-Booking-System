package Models.Vehicle.DB;

import com.aerospike.mapper.annotations.AerospikeRecord;

@AerospikeRecord(namespace="test", set="bus")
public class BusDB extends VehicleDB {


}
