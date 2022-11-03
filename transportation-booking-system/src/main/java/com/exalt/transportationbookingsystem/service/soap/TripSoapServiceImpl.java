package com.exalt.transportationbookingsystem.service.soap;

import com.exalt.transportationbookingsystem.dataaccess.personrepository.UserRepository;
import com.exalt.transportationbookingsystem.dataaccess.personrepository.UserRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.BusTripRepository;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.FlightRepository;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.TrainTripRepository;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.BusTripRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.FlightRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.TrainTripRepositoryImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;
import com.exalt.transportationbookingsystem.models.trip.mapperinterfaces.BusTripMapper;
import com.exalt.transportationbookingsystem.models.trip.mapperinterfaces.FlightMapper;
import com.exalt.transportationbookingsystem.models.trip.mapperinterfaces.TrainTripMapper;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.BusMapper;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.PlaneMapper;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.TrainMapper;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserTripListsDTO;
import com.exalt.transportationbookingsystem.models.person.mapperinterfaces.DriverMapper;
import com.exalt.transportationbookingsystem.models.person.mapperinterfaces.UserMapper;

/**
 * The type Trip soap service.
 */
public class TripSoapServiceImpl implements TripSoapService{


    private final String busTripNotFoundMsg = "busTrip not found";
    private final String trainTripNotFoundMsg = "trainTrip not found";
    private final String flightNotFoundMsg = "flight not found";
    private final String userNotFoundMsg = "user not found";
    /**
     * The Bus trip dao.
     */
    BusTripRepository busTripDao = new BusTripRepositoryImpl();
    /**
     * The Train trip dao.
     */
    TrainTripRepository trainTripDao = new TrainTripRepositoryImpl();
    /**
     * The Flight dao.
     */
    FlightRepository flightDao = new FlightRepositoryImpl();
    /**
     * The User dao.
     */
    UserRepository userDao = new UserRepositoryImpl();
    @Override
    public BusTripDTO getBusTripById(int id) throws NotFoundException {
        BusTripDB busTripDB = busTripDao.readBusTripById(id);
        if (busTripDB == null){
            throw new NotFoundException(busTripNotFoundMsg);
        }
        BusTripDTO busTripDTO = BusTripMapper.INSTANCE.busTripDbToBusTripDto(busTripDB);

        BusDTO busDTO = BusMapper.INSTANCE.busDbToBusDto(busTripDB.getBus());
        DriverDTO driverDTO = DriverMapper.INSTANCE.driverDbToDriverDto(busTripDB.getBus().getDriver());
        busDTO.setRefDriver(driverDTO);

        UserDTO userDTO = UserMapper.INSTANCE.userDbToUserDto(busTripDB.getUser());

        busTripDTO.setRefBus(busDTO);
        busTripDTO.setRefUser(userDTO);
        return busTripDTO;
    }

    @Override
    public TrainTripDTO getTrainTripById(int id) throws NotFoundException {
        TrainTripDB trainTripDB = trainTripDao.readTrainTripById(id);
        if (trainTripDB == null){
            throw new NotFoundException(trainTripNotFoundMsg);
        }
        TrainTripDTO trainTripDTO = TrainTripMapper.INSTANCE.trainTripDbToTrainTripDto(trainTripDB);

        TrainDTO trainDTO = TrainMapper.INSTANCE.trainDbToTrainDto(trainTripDB.getTrain());
        DriverDTO driverDTO = DriverMapper.INSTANCE.driverDbToDriverDto(trainTripDB.getTrain().getDriver());
        trainDTO.setRefDriver(driverDTO);

        UserDTO userDTO = UserMapper.INSTANCE.userDbToUserDto(trainTripDB.getUser());

        trainTripDTO.setRefTrain(trainDTO);
        trainTripDTO.setRefUser(userDTO);
        return trainTripDTO;
    }

    @Override
    public FlightDTO getFlightById(int id) throws NotFoundException {
        FlightDB flightDB = flightDao.readFlightById(id);
        if (flightDB == null){
            throw new NotFoundException(flightNotFoundMsg);
        }
        FlightDTO flightDTO = FlightMapper.INSTANCE.flightDbToFlightDto(flightDB);

        PlaneDTO planeDTO = PlaneMapper.INSTANCE.planeDbToPlaneDto(flightDB.getPlane());
        DriverDTO driverDTO = DriverMapper.INSTANCE.driverDbToDriverDto(flightDB.getPlane().getDriver());
        planeDTO.setRefDriver(driverDTO);

        UserDTO userDTO = UserMapper.INSTANCE.userDbToUserDto(flightDB.getUser());

        flightDTO.setRefPlane(planeDTO);
        flightDTO.setRefUser(userDTO);
        return flightDTO;
    }

    @Override
    public UserTripListsDTO getAllTripsByUserId (int id) throws NotFoundException {
        UserDB userDB = userDao.readUserById(id);
        if (userDB == null){
            throw new NotFoundException(userNotFoundMsg);
        }
        UserTripListsDTO userListDTO = UserMapper.INSTANCE.userListsDbToUserListsDto(userDB);
        return userListDTO;
    }

}
