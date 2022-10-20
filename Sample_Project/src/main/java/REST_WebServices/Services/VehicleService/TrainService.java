package REST_WebServices.Services.VehicleService;

import DB_Configuration.Aerospike;
import Models.Person.DB.DriverDB;
import Models.Vehicle.DB.TrainDB;
import Models.Vehicle.DTO.TrainDTO;
import Models.Vehicle.MapperInterfaces.TrainMapper;

public class TrainService {
    Aerospike aerospike = new Aerospike();

    public void AddTrain(TrainDTO train){

        // mapper
        TrainDB trainDB = TrainMapper.INSTANCE.TrainDtoToTrainDb(train);
        DriverDB driver = aerospike.mapper.read(DriverDB.class, train.getRefDriverId());
        trainDB.setDriver(driver);
        aerospike.mapper.save(trainDB);
    }


    public String UpdateTrain(TrainDTO train){
        TrainDB trainDB = TrainMapper.INSTANCE.TrainDtoToTrainDb(train);
        if ((aerospike.mapper.read(TrainDB.class, train.getId()) != null)) {
            aerospike.mapper.update(trainDB,"license", "manifac_country","model","colour","no_of_seats","railwayStation");
            return "updated";
        }
        else {
            return "not found";
        }
    }
}
