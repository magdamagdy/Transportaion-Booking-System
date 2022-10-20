package REST_WebServices.Services.PersonService;

import DB_Configuration.Aerospike;
import Models.Person.DB.DriverDB;
import Models.Person.DB.UserDB;
import Models.Person.DTO.DriverDTO;
import Models.Person.DTO.UserDTO;
import Models.Person.MapperInterfaces.DriverMapper;
import Models.Person.MapperInterfaces.UserMapper;

public class UserService {
    Aerospike aerospike = new Aerospike();
    public void AddUser(UserDTO user){
        UserDB userDB = UserMapper.INSTANCE.UserDtoToUserDb(user);
        aerospike.mapper.save(userDB);
    }

    public String UpdateUser(UserDTO user){
        UserDB userDB = UserMapper.INSTANCE.UserDtoToUserDb(user);
        if ((aerospike.mapper.read(UserDB.class, user.getId()) != null)) {
            aerospike.mapper.update(userDB,"age", "gender", "phone", "email");
            return "updated";
        }
        else {
            return "not found";
        }
    }
}
