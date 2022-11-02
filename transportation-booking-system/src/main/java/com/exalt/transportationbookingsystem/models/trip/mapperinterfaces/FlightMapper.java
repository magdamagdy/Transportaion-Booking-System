package com.exalt.transportationbookingsystem.models.trip.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper( FlightMapper.class );

    @Mapping(source = "refPlaneId", target = "plane", ignore = true)
    @Mapping(source ="refUserId", target = "user", ignore = true)
    FlightDB flightDtoToFlightDb(FlightDTO plane);

    @Mapping(source = "plane", target = "refPlaneId", ignore = true)
    @Mapping(source ="user", target = "refUserId", ignore = true)
    FlightDTO flightDbToFlightDto(FlightDB plane);
}
