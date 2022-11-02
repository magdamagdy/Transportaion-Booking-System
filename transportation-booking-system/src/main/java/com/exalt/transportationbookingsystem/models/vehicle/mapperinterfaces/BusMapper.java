package com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusMapper {
    BusMapper INSTANCE = Mappers.getMapper( BusMapper.class );

    @Mapping(source = "refDriverId", target = "driver", ignore = true)
    BusDB busDtoToBusDb(BusDTO bus);

    @Mapping(source = "driver", target = "refDriverId", ignore = true)
    BusDTO busDbToBusDto(BusDB bus);
}
