package com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The interface Plane mapper.
 */
@Mapper
public interface PlaneMapper {

    /**
     * The constant INSTANCE.
     */
    PlaneMapper INSTANCE = Mappers.getMapper( PlaneMapper.class );

    /**
     * Plane dto to plane db.
     *
     * @param plane the plane
     * @return the plane db
     */
    @Mapping(source = "refDriverId", target = "driver", ignore = true)
    PlaneDB planeDtoToPlaneDb(PlaneDTO plane);

    /**
     * Plane db to plane dto.
     *
     * @param plane the plane
     * @return the plane dto
     */
    @Mapping(source = "driver", target = "refDriverId", ignore = true)
    PlaneDTO planeDbToPlaneDto(PlaneDB plane);
}
