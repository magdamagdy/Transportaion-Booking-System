package com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces;

import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainMapper {

    TrainMapper INSTANCE = Mappers.getMapper( TrainMapper.class );

    @Mapping(source = "refDriverId", target = "driver", ignore = true)
    TrainDB trainDtoToTrainDb(TrainDTO train);

    @Mapping(source = "driver", target = "refDriverId", ignore = true)
    TrainDTO trainDbToTrainDto(TrainDB train);
}
