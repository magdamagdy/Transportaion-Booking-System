package SOAP_WebServices;


import DB_Configuration.Aerospike;
import Models.Person.DTO.DriverDTO;
import Models.Person.MapperInterfaces.DriverMapper;
import Models.Vehicle.DB.BusDB;
import Models.Vehicle.DB.PlaneDB;
import Models.Vehicle.DB.TrainDB;
import Models.Vehicle.DTO.BusDTO;
import Models.Vehicle.DTO.PlaneDTO;
import Models.Vehicle.DTO.TrainDTO;
import Models.Vehicle.MapperInterfaces.BusMapper;
import Models.Vehicle.MapperInterfaces.PlaneMapper;
import Models.Vehicle.MapperInterfaces.TrainMapper;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;


@WebService
public class VehicleSoapService {

    Aerospike aerospike = new Aerospike();
    @WebMethod
    public BusDTO GetBusById(int id){
        BusDB busDB = aerospike.mapper.read(BusDB.class, id);
        BusDTO busDTO = BusMapper.INSTANCE.BusDbToBusDto(busDB);

        DriverDTO driverDTO = DriverMapper.INSTANCE.DriverDbToDriverDto(busDB.getDriver());
        busDTO.setRefDriver(driverDTO);
        return busDTO;
    }

    @WebMethod
    public TrainDTO GetTrainById(int id){
        TrainDB trainDB = aerospike.mapper.read(TrainDB.class, id);
        TrainDTO trainDTO = TrainMapper.INSTANCE.TrainDbToTrainDto(trainDB);

        DriverDTO driverDTO = DriverMapper.INSTANCE.DriverDbToDriverDto(trainDB.getDriver());
        trainDTO.setRefDriver(driverDTO);
        return trainDTO;
    }

    @WebMethod
    public PlaneDTO GetPlaneById(int id){
        PlaneDB planeDB = aerospike.mapper.read(PlaneDB.class, id);
        PlaneDTO planeDTO = PlaneMapper.INSTANCE.PlaneDbToPlaneDto(planeDB);

        DriverDTO driverDTO = DriverMapper.INSTANCE.DriverDbToDriverDto(planeDB.getDriver());
        planeDTO.setRefDriver(driverDTO);
        return planeDTO;
    }

    @WebMethod
    public List<BusDTO> GetAllBuses(){
        List<BusDB> AllBuses = new ArrayList<>(aerospike.mapper.scan(BusDB.class));
        List<BusDTO> AllBusesDTO = new ArrayList<>();
        for (BusDB i : AllBuses) {
            BusDTO busDTO = BusMapper.INSTANCE.BusDbToBusDto(i);
            AllBusesDTO.add(busDTO);
        }
        return AllBusesDTO;
    }

    @WebMethod
    public List<TrainDTO> GetAllTrains(){
        List<TrainDB> AllTrains = new ArrayList<>(aerospike.mapper.scan(TrainDB.class));
        List<TrainDTO> AllTrainsDTO = new ArrayList<>();
        for (TrainDB i : AllTrains) {
            TrainDTO trainDTO = TrainMapper.INSTANCE.TrainDbToTrainDto(i);
            AllTrainsDTO.add(trainDTO);
        }
        return AllTrainsDTO;
    }

    @WebMethod
    public List<PlaneDTO> GetAllPlanes(){
        List<PlaneDB> AllPlanes = new ArrayList<>(aerospike.mapper.scan(PlaneDB.class));
        List<PlaneDTO> AllPlanesDTO = new ArrayList<>();
        for (PlaneDB i : AllPlanes) {
            PlaneDTO planeDTO = PlaneMapper.INSTANCE.PlaneDbToPlaneDto(i);
            AllPlanesDTO.add(planeDTO);
        }
        return AllPlanesDTO;
    }
}
