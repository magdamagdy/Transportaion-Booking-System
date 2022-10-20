package Models.Trip.MapperInterfaces;

import Models.Trip.DB.BusTripDB;
import Models.Trip.DTO.BusTripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusTripMapper {
    BusTripMapper INSTANCE = Mappers.getMapper( BusTripMapper.class );

    @Mapping(source = "refBusId", target = "bus", ignore = true)
    @Mapping(source ="refUserId", target = "user", ignore = true)
    BusTripDB BusTripDtoToBusTripDb(BusTripDTO bus);

    @Mapping(source = "bus",target = "refBusId",ignore = true )
    @Mapping(source = "user", target = "refUserId", ignore = true)
    BusTripDTO BusTripDbToBusTripDto(BusTripDB bus);
}
