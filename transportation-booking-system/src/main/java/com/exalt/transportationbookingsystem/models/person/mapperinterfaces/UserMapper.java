package com.exalt.transportationbookingsystem.models.person.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserTripListsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The interface User mapper.
 */
@Mapper
public interface UserMapper {

    /**
     * The constant INSTANCE.
     */
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    /**
     * User dto to user db.
     *
     * @param user the user
     * @return the user db
     */
    UserDB userDtoToUserDb(UserDTO user);

    /**
     * User db to user dto.
     *
     * @param user the user
     * @return the user dto
     */
    UserDTO userDbToUserDto(UserDB user);

    /**
     * User lists db to user lists dto.
     *
     * @param user the user
     * @return the user trip lists dto
     */
    @Mapping(source = "busTrips" , target = "busTrip")
    @Mapping(source = "trainTrips" , target = "trainTrip")
    @Mapping(source = "flights" , target = "flight")
    UserTripListsDTO userListsDbToUserListsDto (UserDB user);

}
