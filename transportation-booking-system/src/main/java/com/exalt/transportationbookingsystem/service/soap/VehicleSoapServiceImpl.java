package com.exalt.transportationbookingsystem.service.soap;

import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.BusRepository;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.PlaneRepository;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.TrainRepository;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.BusRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.PlaneRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.TrainRepositoryImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.BusMapper;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.PlaneMapper;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.TrainMapper;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import com.exalt.transportationbookingsystem.models.person.mapperinterfaces.DriverMapper;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Vehicle soap service.
 */
public class VehicleSoapServiceImpl implements VehicleSoapService{

    private final String busNotFoundMsg = "bus not found";
    private final String trainNotFoundMsg = "train not found";
    private final String planeNotFoundMsg = "plane not found";
    /**
     * The Bus dao.
     */
    BusRepository busDao = new BusRepositoryImpl();
    /**
     * The Train dao.
     */
    TrainRepository trainDao = new TrainRepositoryImpl();
    /**
     * The Plane dao.
     */
    PlaneRepository planeDao = new PlaneRepositoryImpl();

    @Override
    public BusDTO getBusById(int id) throws NotFoundException {
        BusDB busDB = busDao.readBusById(id);
        if(busDB == null){
            throw new NotFoundException(busNotFoundMsg);
        }
        BusDTO busDTO = BusMapper.INSTANCE.busDbToBusDto(busDB);

        DriverDTO driverDTO = DriverMapper.INSTANCE.driverDbToDriverDto(busDB.getDriver());
        busDTO.setRefDriver(driverDTO);
        return busDTO;
    }

    @Override
    public TrainDTO getTrainById(int id) throws NotFoundException {
        TrainDB trainDB = trainDao.readTrainById(id);
        if(trainDB == null){
            throw new NotFoundException(trainNotFoundMsg);
        }
        TrainDTO trainDTO = TrainMapper.INSTANCE.trainDbToTrainDto(trainDB);

        DriverDTO driverDTO = DriverMapper.INSTANCE.driverDbToDriverDto(trainDB.getDriver());
        trainDTO.setRefDriver(driverDTO);
        return trainDTO;
    }

    @Override
    public PlaneDTO getPlaneById(int id) throws NotFoundException {
        PlaneDB planeDB = planeDao.readPlaneById(id);
        if(planeDB == null){
            throw new NotFoundException(planeNotFoundMsg);
        }
        PlaneDTO planeDTO = PlaneMapper.INSTANCE.planeDbToPlaneDto(planeDB);

        DriverDTO driverDTO = DriverMapper.INSTANCE.driverDbToDriverDto(planeDB.getDriver());
        planeDTO.setRefDriver(driverDTO);
        return planeDTO;
    }

    @Override
    public List<BusDTO> getAllBuses(){
        List<BusDB> AllBuses = new ArrayList<>(busDao.readAllBuses());
        List<BusDTO> AllBusesDTO = new ArrayList<>();
        for (BusDB i : AllBuses) {
            BusDTO busDTO = BusMapper.INSTANCE.busDbToBusDto(i);
            AllBusesDTO.add(busDTO);
        }
        return AllBusesDTO;
    }

    @Override
    public List<TrainDTO> getAllTrains(){
        List<TrainDB> AllTrains = new ArrayList<>(trainDao.readAllTrains());
        List<TrainDTO> AllTrainsDTO = new ArrayList<>();
        for (TrainDB i : AllTrains) {
            TrainDTO trainDTO = TrainMapper.INSTANCE.trainDbToTrainDto(i);
            AllTrainsDTO.add(trainDTO);
        }
        return AllTrainsDTO;
    }

    @Override
    public List<PlaneDTO> getAllPlanes(){
        List<PlaneDB> AllPlanes = new ArrayList<>(planeDao.readAllPlanes());
        List<PlaneDTO> AllPlanesDTO = new ArrayList<>();
        for (PlaneDB i : AllPlanes) {
            PlaneDTO planeDTO = PlaneMapper.INSTANCE.planeDbToPlaneDto(i);
            AllPlanesDTO.add(planeDTO);
        }
        return AllPlanesDTO;
    }
}
