package Models.Person.MapperInterfaces;

import Models.Person.DB.DriverDB;
import Models.Person.DTO.DriverDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper( DriverMapper.class );


    DriverDB DriverDtoToDriverDb(DriverDTO driver);
    DriverDTO DriverDbToDriverDto(DriverDB driver);

}
