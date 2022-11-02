package com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlaneMapper {

    PlaneMapper INSTANCE = Mappers.getMapper( PlaneMapper.class );

    @Mapping(source = "refDriverId", target = "driver", ignore = true)
    PlaneDB planeDtoToPlaneDb(PlaneDTO plane);

    @Mapping(source = "driver", target = "refDriverId", ignore = true)
    PlaneDTO planeDbToPlaneDto(PlaneDB plane);
}
