package com.exalt.transportationbookingsystem.service.soap.client;

import com.exalt.transportationbookingsystem.dataaccess.triprepository.BusTripRepository;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.FlightRepository;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.TrainTripRepository;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.BusTripRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.FlightRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.triprepository.TrainTripRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.BusRepository;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.PlaneRepository;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.TrainRepository;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.BusRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.PlaneRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.TrainRepositoryImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.RestrictDeleteException;
import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Vehicle soap client.
 */
@WebService
public class VehicleSoapClient {

    private final String notFoundMsg = "Object not found to delete it";
    private final String restrictDeleteMsg = "Restrict delete for this object";

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
     * Delete bus by id.
     *
     * @param id the id
     * @throws RestrictDeleteException the restrict delete exception
     * @throws NotFoundException       the not found exception
     */
    @WebMethod
    public void deleteBusById(int id) throws RestrictDeleteException, NotFoundException {
        if (busDao.readBusById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        List<BusTripDB> AllTrips = new ArrayList<>(busTripDao.readAllBusTrips());
        for (BusTripDB i : AllTrips) {
            if (i.getBus().getId() == id){
                throw new RestrictDeleteException(restrictDeleteMsg);
            }
        }
        //else if bus not assigned to any trip delete it
        busDao.deleteBusById(id);
    }

    /**
     * Delete train by id.
     *
     * @param id the id
     * @throws NotFoundException       the not found exception
     * @throws RestrictDeleteException the restrict delete exception
     */
    @WebMethod
    public void deleteTrainById(int id) throws NotFoundException, RestrictDeleteException {
        if (trainDao.readTrainById(id) == null){
            throw new NotFoundException(notFoundMsg);
        }
        List<TrainTripDB> AllTrips = new ArrayList<>(trainTripDao.readAllTrainTrips());
        for (TrainTripDB i : AllTrips) {
            if (i.getTrain().getId() == id){
                throw new RestrictDeleteException(restrictDeleteMsg);
            }
        }
        //else if train not assigned to any trip delete it
        trainDao.deleteTrainById(id);
    }

    /**
     * Delete plane by id.
     *
     * @param id the id
     * @throws NotFoundException       the not found exception
     * @throws RestrictDeleteException the restrict delete exception
     */
    @WebMethod
    public void deletePlaneById(int id) throws NotFoundException, RestrictDeleteException {
        if (planeDao.readPlaneById(id) == null) {
            throw new NotFoundException(notFoundMsg);
        }
        List<FlightDB> AllTrips = new ArrayList<>(flightDao.readAllFlights());
        for (FlightDB i : AllTrips) {
            if (i.getPlane().getId() == id){
                throw new RestrictDeleteException(restrictDeleteMsg);
            }
        }
        //else if plane not assigned to any flight delete it
        planeDao.deletePlaneById(id);
    }
}
