package Models.Person.MapperInterfaces;


import Models.Person.DB.UserDB;
import Models.Person.DTO.UserDTO;
import Models.Person.DTO.UserTripListsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );


    UserDB UserDtoToUserDb(UserDTO user);

    UserDTO UserDbToUserDto(UserDB user);

    @Mapping(source = "bus_Trips" , target = "bus_Trip")
    @Mapping(source = "train_Trips" , target = "train_Trip")
    @Mapping(source = "flights_" , target = "flight")
    UserTripListsDTO userListsDbToUserListsDto (UserDB user);

}
