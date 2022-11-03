package com.exalt.transportationbookingsystem.service.soap.client;


import com.exalt.transportationbookingsystem.dataaccess.personrepository.DriverRepository;
import com.exalt.transportationbookingsystem.dataaccess.personrepository.UserRepository;
import com.exalt.transportationbookingsystem.dataaccess.personrepository.DriverRepositoryImpl;
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

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Person soap client.
 */
@WebService
public class PersonSoapClient {

    private final String notFoundMsg = "Object not found to delete it";
    /**
     * The Driver dao.
     */
    DriverRepository driverDao = new DriverRepositoryImpl();
    /**
     * The User dao.
     */
    UserRepository userDao = new UserRepositoryImpl();
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
     * Delete user by id.
     * Cascade delete
     * Delete all trips related to this user then delete the user itself
     * @param id the id
     * @throws NotFoundException the not found exception
     */
    @WebMethod
    public void deleteUserById (int id) throws NotFoundException {
        if (userDao.readUserById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        List<BusTripDB> AllBusTrips = new ArrayList<>(busTripDao.readAllBusTrips());
        List<TrainTripDB> AllTrainTrips = new ArrayList<>(trainTripDao.readAllTrainTrips());
        List<FlightDB> AllFlights = new ArrayList<>(flightDao.readAllFlights());

        for (BusTripDB i: AllBusTrips) {
            if(i.getUser().getId() == id)
            {
                busTripDao.deleteBusTripById(i.getId());
            }
        }
        for (TrainTripDB i: AllTrainTrips) {
            if(i.getUser().getId() == id)
            {
                trainTripDao.deleteTrainTripById(i.getId());
            }
        }
        for (FlightDB i: AllFlights) {
            if(i.getUser().getId() == id)
            {
                flightDao.deleteFlightById(i.getId());
            }
        }
        userDao.deleteUserById(id);
    }

    /**
     * Delete driver by id.
     *
     * @param id the id
     * @throws NotFoundException the not found exception
     */
    @WebMethod
    public void deleteDriverById(int id) throws NotFoundException {
        if (driverDao.readDriverById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        driverDao.deleteDriverById(id);
    }

}


