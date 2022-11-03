package com.exalt.transportationbookingsystem.models.trip.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The interface Flight mapper.
 */
@Mapper
public interface FlightMapper {

    /**
     * The constant INSTANCE.
     */
    FlightMapper INSTANCE = Mappers.getMapper( FlightMapper.class );

    /**
     * Flight dto to flight db.
     *
     * @param plane the plane
     * @return the flight db
     */
    @Mapping(source = "refPlaneId", target = "plane", ignore = true)
    @Mapping(source ="refUserId", target = "user", ignore = true)
    FlightDB flightDtoToFlightDb(FlightDTO plane);

    /**
     * Flight db to flight dto.
     *
     * @param plane the plane
     * @return the flight dto
     */
    @Mapping(source = "plane", target = "refPlaneId", ignore = true)
    @Mapping(source ="user", target = "refUserId", ignore = true)
    FlightDTO flightDbToFlightDto(FlightDB plane);
}
