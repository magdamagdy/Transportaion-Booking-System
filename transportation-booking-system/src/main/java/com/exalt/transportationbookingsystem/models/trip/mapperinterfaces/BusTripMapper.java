package com.exalt.transportationbookingsystem.models.trip.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusTripMapper {
    BusTripMapper INSTANCE = Mappers.getMapper( BusTripMapper.class );

    @Mapping(source = "refBusId", target = "bus", ignore = true)
    @Mapping(source ="refUserId", target = "user", ignore = true)
    BusTripDB busTripDtoToBusTripDb(BusTripDTO bus);

    @Mapping(source = "bus",target = "refBusId",ignore = true )
    @Mapping(source = "user", target = "refUserId", ignore = true)
    BusTripDTO busTripDbToBusTripDto(BusTripDB bus);
}
