package com.exalt.transportationbookingsystem.models.trip.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainTripMapper {
    TrainTripMapper INSTANCE = Mappers.getMapper( TrainTripMapper.class );

    @Mapping(source = "refTrainId", target = "train", ignore = true)
    @Mapping(source ="refUserId", target = "user", ignore = true)
    TrainTripDB trainTripDtoToTrainTripDb(TrainTripDTO train);

    @Mapping(source = "train", target = "refTrainId", ignore = true)
    @Mapping(source ="user", target = "refUserId", ignore = true)
    TrainTripDTO trainTripDbToTrainTripDto(TrainTripDB train);
}
