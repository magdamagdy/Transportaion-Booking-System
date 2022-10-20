package Models.Trip.MapperInterfaces;


import Models.Trip.DB.TrainTripDB;
import Models.Trip.DTO.TrainTripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainTripMapper {
    TrainTripMapper INSTANCE = Mappers.getMapper( TrainTripMapper.class );

    @Mapping(source = "refTrainId", target = "train", ignore = true)
    @Mapping(source ="refUserId", target = "user", ignore = true)
    TrainTripDB TrainTripDtoToTrainTripDb(TrainTripDTO train);

    @Mapping(source = "train", target = "refTrainId", ignore = true)
    @Mapping(source ="user", target = "refUserId", ignore = true)
    TrainTripDTO TrainTripDbToTrainTripDto(TrainTripDB train);
}
