package SOAP_WebServices;

import DB_Configuration.Aerospike;
import Models.Person.DB.UserDB;
import Models.Person.DTO.DriverDTO;
import Models.Person.DTO.UserDTO;
import Models.Person.DTO.UserTripListsDTO;
import Models.Person.MapperInterfaces.DriverMapper;
import Models.Person.MapperInterfaces.UserMapper;
import Models.Trip.DB.BusTripDB;
import Models.Trip.DB.FlightDB;
import Models.Trip.DB.TrainTripDB;
import Models.Trip.DTO.BusTripDTO;
import Models.Trip.DTO.FlightDTO;
import Models.Trip.DTO.TrainTripDTO;
import Models.Trip.MapperInterfaces.BusTripMapper;
import Models.Trip.MapperInterfaces.FlightMapper;
import Models.Trip.MapperInterfaces.TrainTripMapper;
import Models.Vehicle.DTO.BusDTO;
import Models.Vehicle.DTO.PlaneDTO;
import Models.Vehicle.DTO.TrainDTO;
import Models.Vehicle.MapperInterfaces.BusMapper;
import Models.Vehicle.MapperInterfaces.PlaneMapper;
import Models.Vehicle.MapperInterfaces.TrainMapper;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


@WebService
public class TripSoapService {

    Aerospike aerospike = new Aerospike();

    @WebMethod
    public BusTripDTO GetBusTripById(int id){

        BusTripDB busTripDB = aerospike.mapper.read(BusTripDB.class, id);
        BusTripDTO busTripDTO = BusTripMapper.INSTANCE.BusTripDbToBusTripDto(busTripDB);

        BusDTO busDTO = BusMapper.INSTANCE.BusDbToBusDto(busTripDB.getBus());
        DriverDTO driverDTO = DriverMapper.INSTANCE.DriverDbToDriverDto(busTripDB.getBus().getDriver());
        busDTO.setRefDriver(driverDTO);

        UserDTO userDTO = UserMapper.INSTANCE.UserDbToUserDto(busTripDB.getUser());

        busTripDTO.setRefBus(busDTO);
        busTripDTO.setRefUser(userDTO);

        return busTripDTO;
    }

    @WebMethod
    public TrainTripDTO GetTrainTripById(int id){

        TrainTripDB trainTripDB = aerospike.mapper.read(TrainTripDB.class, id);
        TrainTripDTO trainTripDTO = TrainTripMapper.INSTANCE.TrainTripDbToTrainTripDto(trainTripDB);

        TrainDTO trainDTO = TrainMapper.INSTANCE.TrainDbToTrainDto(trainTripDB.getTrain());
        DriverDTO driverDTO = DriverMapper.INSTANCE.DriverDbToDriverDto(trainTripDB.getTrain().getDriver());
        trainDTO.setRefDriver(driverDTO);

        UserDTO userDTO = UserMapper.INSTANCE.UserDbToUserDto(trainTripDB.getUser());

        trainTripDTO.setRefTrain(trainDTO);
        trainTripDTO.setRefUser(userDTO);

        return trainTripDTO;
    }

    @WebMethod
    public FlightDTO GetFlightById(int id){

        FlightDB flightDB = aerospike.mapper.read(FlightDB.class, id);
        FlightDTO flightDTO = FlightMapper.INSTANCE.FlightDbToFlightDto(flightDB);

        PlaneDTO planeDTO = PlaneMapper.INSTANCE.PlaneDbToPlaneDto(flightDB.getPlane());
        DriverDTO driverDTO = DriverMapper.INSTANCE.DriverDbToDriverDto(flightDB.getPlane().getDriver());
        planeDTO.setRefDriver(driverDTO);

        UserDTO userDTO = UserMapper.INSTANCE.UserDbToUserDto(flightDB.getUser());

        flightDTO.setRefPlane(planeDTO);
        flightDTO.setRefUser(userDTO);

        return flightDTO;
    }


    @WebMethod
    public UserTripListsDTO GetAllTripsByUserId (int id){
        UserDB userDB = aerospike.mapper.read(UserDB.class, id);
        UserTripListsDTO userListDTO = UserMapper.INSTANCE.userListsDbToUserListsDto(userDB);
        return userListDTO;
    }

}
