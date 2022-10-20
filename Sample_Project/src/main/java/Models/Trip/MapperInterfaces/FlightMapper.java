package Models.Trip.MapperInterfaces;

import Models.Trip.DB.FlightDB;
import Models.Trip.DTO.FlightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper( FlightMapper.class );

    @Mapping(source = "refPlaneId", target = "plane", ignore = true)
    @Mapping(source ="refUserId", target = "user", ignore = true)
    FlightDB FlightDtoToFlightDb(FlightDTO plane);

    @Mapping(source = "plane", target = "refPlaneId", ignore = true)
    @Mapping(source ="user", target = "refUserId", ignore = true)
    FlightDTO FlightDbToFlightDto(FlightDB plane);
}
