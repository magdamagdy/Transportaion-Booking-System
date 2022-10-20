package Models.Vehicle.MapperInterfaces;


import Models.Vehicle.DB.TrainDB;
import Models.Vehicle.DTO.TrainDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainMapper {

    TrainMapper INSTANCE = Mappers.getMapper( TrainMapper.class );

    @Mapping(source = "refDriverId", target = "driver", ignore = true)
    TrainDB TrainDtoToTrainDb(TrainDTO train);

    @Mapping(source = "driver", target = "refDriverId", ignore = true)
    TrainDTO TrainDbToTrainDto(TrainDB train);
}
