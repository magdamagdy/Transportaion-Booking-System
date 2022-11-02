package com.exalt.transportationbookingsystem.models.person.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The interface Driver mapper.
 */
@Mapper
public interface DriverMapper {

    /**
     * The constant INSTANCE.
     */
    DriverMapper INSTANCE = Mappers.getMapper( DriverMapper.class );

    /**
     * Driver dto to driver db.
     *
     * @param driver the driver
     * @return the driver db
     */
    DriverDB driverDtoToDriverDb(DriverDTO driver);

    /**
     * Driver db to driver dto.
     *
     * @param driver the driver
     * @return the driver dto
     */
    DriverDTO driverDbToDriverDto(DriverDB driver);

}
