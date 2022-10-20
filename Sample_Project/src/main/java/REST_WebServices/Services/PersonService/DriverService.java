package REST_WebServices.Services.PersonService;

import DB_Configuration.Aerospike;
import Models.Person.DB.DriverDB;
import Models.Person.DTO.DriverDTO;
import Models.Person.MapperInterfaces.DriverMapper;

public class DriverService {

    Aerospike aerospike = new Aerospike();
    public void AddDriver(DriverDTO driver){
        DriverDB driverDB = DriverMapper.INSTANCE.DriverDtoToDriverDb(driver);
        aerospike.mapper.save(driverDB);
    }

    public String UpdateDriver(DriverDTO driver){
        DriverDB driverDB = DriverMapper.INSTANCE.DriverDtoToDriverDb(driver);
        if ((aerospike.mapper.read(DriverDB.class, driver.getId()) != null)) {
            aerospike.mapper.update(driverDB,"age", "gender", "phone", "email", "license", "years_of_exp");
            return "updated";
        }
        else {
            return "not found";
        }
    }
}
