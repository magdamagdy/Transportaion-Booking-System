package com.exalt.transportationbookingsystem.models.person.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper( DriverMapper.class );


    DriverDB driverDtoToDriverDb(DriverDTO driver);
    DriverDTO driverDbToDriverDto(DriverDB driver);

}
