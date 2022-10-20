package REST_WebServices.Services.VehicleService;

import DB_Configuration.Aerospike;
import Models.Person.DB.DriverDB;
import Models.Vehicle.DB.PlaneDB;
import Models.Vehicle.DTO.PlaneDTO;
import Models.Vehicle.MapperInterfaces.PlaneMapper;

public class PlaneService {

    Aerospike aerospike = new Aerospike();

    public void AddPlane(PlaneDTO plane){

        // mapper
        PlaneDB planeDB = PlaneMapper.INSTANCE.PlaneDtoToPlaneDb(plane);
        DriverDB driver = aerospike.mapper.read(DriverDB.class, plane.getRefDriverId());
        planeDB.setDriver(driver);
        aerospike.mapper.save(planeDB);
    }

    public String UpdatePlane(PlaneDTO plane){
        PlaneDB planeDB = PlaneMapper.INSTANCE.PlaneDtoToPlaneDb(plane);
        if ((aerospike.mapper.read(PlaneDB.class, plane.getId()) != null)) {
            aerospike.mapper.update(planeDB,"license", "manifac_country","model","colour","no_of_seats","airport","airlines");
            return "updated";
        }
        else {
            return "not found";
        }
    }
}
