package com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The interface Bus mapper.
 */
@Mapper
public interface BusMapper {

    /**
     * The constant INSTANCE.
     */
    BusMapper INSTANCE = Mappers.getMapper( BusMapper.class );

    /**
     * Bus dto to bus db.
     *
     * @param bus the bus
     * @return the bus db
     */
    @Mapping(source = "refDriverId", target = "driver", ignore = true)
    BusDB busDtoToBusDb(BusDTO bus);

    /**
     * Bus db to bus dto.
     *
     * @param bus the bus
     * @return the bus dto
     */
    @Mapping(source = "driver", target = "refDriverId", ignore = true)
    BusDTO busDbToBusDto(BusDB bus);
}
