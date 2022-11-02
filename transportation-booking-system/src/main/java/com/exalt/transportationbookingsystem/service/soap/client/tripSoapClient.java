package com.exalt.transportationbookingsystem.service.soap.client;


import com.exalt.transportationbookingsystem.dataaccess.tripdao.BusTripDao;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.FlightDao;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.TrainTripDao;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.busTripDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.flightDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.trainTripDaoImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class tripSoapClient {

    private final String notFoundMsg = "Object not found to delete it";
    BusTripDao busTripDao = new busTripDaoImpl();
    TrainTripDao trainTripDao = new trainTripDaoImpl();
    FlightDao flightDao = new flightDaoImpl();

    @WebMethod
    public void deleteBusTripById (int id) throws NotFoundException {
        if (busTripDao.readBusTripById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        busTripDao.deleteBusTripById(id);
    }

    @WebMethod
    public void deleteTrainTripById (int id) throws NotFoundException {
        if (trainTripDao.readTrainTripById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        trainTripDao.deleteTrainTripById(id);
    }

    @WebMethod
    public void deleteFlightById (int id) throws NotFoundException {
        if (flightDao.readFlightById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        flightDao.deleteFlightById(id);
    }

}
