package com.exalt.transportationbookingsystem.service.soap.client;


import com.exalt.transportationbookingsystem.dataaccess.triprepository.BusTripRepository;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.FlightRepository;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.TrainTripRepository;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.BusTripRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.FlightRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.TrainTripRepositoryImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * The type Trip soap client.
 */
@WebService
public class TripSoapClient {

    private final String notFoundMsg = "Object not found to delete it";
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
