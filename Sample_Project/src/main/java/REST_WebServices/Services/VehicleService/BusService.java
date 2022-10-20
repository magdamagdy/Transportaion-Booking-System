package REST_WebServices.Services.VehicleService;

import DB_Configuration.Aerospike;
import Models.Person.DB.DriverDB;
import Models.Vehicle.DB.BusDB;
import Models.Vehicle.DTO.BusDTO;
import Models.Vehicle.MapperInterfaces.BusMapper;


public class BusService {

    Aerospike aerospike = new Aerospike();

    public void AddBus(BusDTO bus){

        // mapper
        BusDB busDB = BusMapper.INSTANCE.BusDtoToBusDb(bus);
        DriverDB driver = aerospike.mapper.read(DriverDB.class, bus.getRefDriverId());
        busDB.setDriver(driver);
        aerospike.mapper.save(busDB);
    }


    public String UpdateBus(BusDTO bus){
        BusDB busDB = BusMapper.INSTANCE.BusDtoToBusDb(bus);
        if ((aerospike.mapper.read(BusDB.class, bus.getId()) != null)) {
            aerospike.mapper.update(busDB,"license", "manifac_country","model","colour","no_of_seats");
            return "updated";
        }
        else {
            return "not found";
        }
    }

}
