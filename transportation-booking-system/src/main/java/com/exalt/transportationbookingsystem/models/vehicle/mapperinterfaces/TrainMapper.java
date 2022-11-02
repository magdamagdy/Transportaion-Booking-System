package com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The interface Train mapper.
 */
@Mapper
public interface TrainMapper {

    /**
     * The constant INSTANCE.
     */
    TrainMapper INSTANCE = Mappers.getMapper( TrainMapper.class );

    /**
     * Train dto to train db.
     *
     * @param train the train
     * @return the train db
     */
    @Mapping(source = "refDriverId", target = "driver", ignore = true)
    TrainDB trainDtoToTrainDb(TrainDTO train);

    /**
     * Train db to train dto.
     *
     * @param train the train
     * @return the train dto
     */
    @Mapping(source = "driver", target = "refDriverId", ignore = true)
    TrainDTO trainDbToTrainDto(TrainDB train);
}
