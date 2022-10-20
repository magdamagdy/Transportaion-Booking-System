package SOAP_WebServices;

import DB_Configuration.Aerospike;
import Models.Person.DB.DriverDB;
import Models.Person.DB.UserDB;
import Models.Person.DTO.DriverDTO;
import Models.Person.DTO.UserDTO;
import Models.Person.MapperInterfaces.DriverMapper;
import Models.Person.MapperInterfaces.UserMapper;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService
public class PersonSoapService {

    Aerospike aerospike = new Aerospike();

    @WebMethod
    public UserDTO GetUserById(int id){
        UserDB userDB = aerospike.mapper.read(UserDB.class, id);
        UserDTO userDTO = UserMapper.INSTANCE.UserDbToUserDto(userDB);
        return userDTO;
    }

    @WebMethod
    public DriverDTO GetDriverById(int id){
        DriverDB driverDB = aerospike.mapper.read(DriverDB.class, id);
        DriverDTO driverDTO = DriverMapper.INSTANCE.DriverDbToDriverDto(driverDB);
        return driverDTO;
    }

    @WebMethod
    public List<UserDTO> GetAllUsers(){
        List<UserDB> AllUsers = new ArrayList<>(aerospike.mapper.scan(UserDB.class));
        List<UserDTO> AllUsersDTO = new ArrayList<>();
        for (UserDB i : AllUsers) {
            UserDTO userDTO = UserMapper.INSTANCE.UserDbToUserDto(i);
            AllUsersDTO.add(userDTO);
        }
        return AllUsersDTO;
    }

    @WebMethod
    public List<DriverDTO> GetAllDrivers(){
        List<DriverDB> AllDrivers = new ArrayList<>(aerospike.mapper.scan(DriverDB.class));
        List<DriverDTO> AllDriversDTO = new ArrayList<>();
        for (DriverDB i : AllDrivers) {
            DriverDTO driverDTO = DriverMapper.INSTANCE.DriverDbToDriverDto(i);
            AllDriversDTO.add(driverDTO);
        }
        return AllDriversDTO;
    }

}
