package Models.Vehicle.MapperInterfaces;

import Models.Vehicle.DB.BusDB;
import Models.Vehicle.DTO.BusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusMapper {
    BusMapper INSTANCE = Mappers.getMapper( BusMapper.class );

    @Mapping(source = "refDriverId", target = "driver", ignore = true)
    BusDB BusDtoToBusDb(BusDTO bus);

    @Mapping(source = "driver", target = "refDriverId", ignore = true)
    BusDTO BusDbToBusDto(BusDB bus);
}
