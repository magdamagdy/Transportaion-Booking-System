package com.exalt.transportationbookingsystem.models.person.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserTripListsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );


    UserDB userDtoToUserDb(UserDTO user);

    UserDTO userDbToUserDto(UserDB user);

    @Mapping(source = "busTrips" , target = "busTrip")
    @Mapping(source = "trainTrips" , target = "trainTrip")
    @Mapping(source = "flights" , target = "flight")
    UserTripListsDTO userListsDbToUserListsDto (UserDB user);

}
