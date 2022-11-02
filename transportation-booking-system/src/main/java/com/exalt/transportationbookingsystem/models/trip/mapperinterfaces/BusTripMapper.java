package com.exalt.transportationbookingsystem.models.trip.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The interface Bus trip mapper.
 */
@Mapper
public interface BusTripMapper {

    /**
     * The constant INSTANCE.
     */
    BusTripMapper INSTANCE = Mappers.getMapper( BusTripMapper.class );

    /**
     * Bus trip dto to bus trip db.
     *
     * @param bus the bus
     * @return the bus trip db
     */
    @Mapping(source = "refBusId", target = "bus", ignore = true)
    @Mapping(source ="refUserId", target = "user", ignore = true)
    BusTripDB busTripDtoToBusTripDb(BusTripDTO bus);

    /**
     * Bus trip db to bus trip dto.
     *
     * @param bus the bus
     * @return the bus trip dto
     */
    @Mapping(source = "bus",target = "refBusId",ignore = true )
    @Mapping(source = "user", target = "refUserId", ignore = true)
    BusTripDTO busTripDbToBusTripDto(BusTripDB bus);
}
