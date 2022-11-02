package com.exalt.transportationbookingsystem.models.trip.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The interface Train trip mapper.
 */
@Mapper
public interface TrainTripMapper {

    /**
     * The constant INSTANCE.
     */
    TrainTripMapper INSTANCE = Mappers.getMapper( TrainTripMapper.class );

    /**
     * Train trip dto to train trip db.
     *
     * @param train the train
     * @return the train trip db
     */
    @Mapping(source = "refTrainId", target = "train", ignore = true)
    @Mapping(source ="refUserId", target = "user", ignore = true)
    TrainTripDB trainTripDtoToTrainTripDb(TrainTripDTO train);

    /**
     * Train trip db to train trip dto.
     *
     * @param train the train
     * @return the train trip dto
     */
    @Mapping(source = "train", target = "refTrainId", ignore = true)
    @Mapping(source ="user", target = "refUserId", ignore = true)
    TrainTripDTO trainTripDbToTrainTripDto(TrainTripDB train);
}
