package Models.Vehicle.MapperInterfaces;

import Models.Vehicle.DB.PlaneDB;
import Models.Vehicle.DTO.PlaneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlaneMapper {

    PlaneMapper INSTANCE = Mappers.getMapper( PlaneMapper.class );

    @Mapping(source = "refDriverId", target = "driver", ignore = true)
    PlaneDB PlaneDtoToPlaneDb(PlaneDTO plane);

    @Mapping(source = "driver", target = "refDriverId", ignore = true)
    PlaneDTO PlaneDbToPlaneDto(PlaneDB plane);
}
