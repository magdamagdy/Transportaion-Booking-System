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

/**
 * The type Trip soap client.
 */
@WebService
public class tripSoapClient {

    private final String notFoundMsg = "Object not found to delete it";
    /**
     * The Bus trip dao.
     */
    BusTripDao busTripDao = new busTripDaoImpl();
    /**
     * The Train trip dao.
     */
    TrainTripDao trainTripDao = new trainTripDaoImpl();
    /**
     * The Flight dao.
     */
    FlightDao flightDao = new flightDaoImpl();

    /**
     * Delete bus trip by id.
     *
     * @param id the id
     * @throws NotFoundException the not found exception
     */
    @WebMethod
    public void deleteBusTripById (int id) throws NotFoundException {
        if (busTripDao.readBusTripById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        busTripDao.deleteBusTripById(id);
    }

    /**
     * Delete train trip by id.
     *
     * @param id the id
     * @throws NotFoundException the not found exception
     */
    @WebMethod
    public void deleteTrainTripById (int id) throws NotFoundException {
        if (trainTripDao.readTrainTripById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        trainTripDao.deleteTrainTripById(id);
    }

    /**
     * Delete flight by id.
     *
     * @param id the id
     * @throws NotFoundException the not found exception
     */
    @WebMethod
    public void deleteFlightById (int id) throws NotFoundException {
        if (flightDao.readFlightById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        flightDao.deleteFlightById(id);
    }

}
