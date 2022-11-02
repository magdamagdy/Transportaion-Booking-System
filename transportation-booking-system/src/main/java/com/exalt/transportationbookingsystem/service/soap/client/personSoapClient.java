package com.exalt.transportationbookingsystem.service.soap.client;


import com.exalt.transportationbookingsystem.dataaccess.persondao.DriverDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.UserDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.driverDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.persondao.userDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.BusTripDao;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.FlightDao;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.TrainTripDao;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.busTripDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.flightDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.trainTripDaoImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class personSoapClient {

    private final String notFoundMsg = "Object not found to delete it";
    DriverDao driverDao = new driverDaoImpl();
    UserDao userDao = new userDaoImpl();
    BusTripDao busTripDao = new busTripDaoImpl();
    TrainTripDao trainTripDao = new trainTripDaoImpl();
    FlightDao flightDao = new flightDaoImpl();

    @WebMethod
    public void deleteUserById (int id) throws NotFoundException {
        //Cascade delete
        //Delete all trips related to this user then delete the user itself
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

    @WebMethod
    public void deleteDriverById(int id) throws NotFoundException {
        if (driverDao.readDriverById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        driverDao.deleteDriverById(id);
    }

}


