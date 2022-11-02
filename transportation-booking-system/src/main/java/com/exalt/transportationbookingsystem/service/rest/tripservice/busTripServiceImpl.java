package com.exalt.transportationbookingsystem.service.rest.tripservice;

import com.exalt.transportationbookingsystem.dataaccess.persondao.UserDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.userDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.BusTripDao;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.busTripDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.BusDao;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.busDaoImpl;
import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import com.exalt.transportationbookingsystem.models.trip.mapperinterfaces.BusTripMapper;
import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class busTripServiceImpl implements BusTripService {

    private final String nullValueMsg = "Null object or Null id";
    private final String notFoundMsg = "BusTrip not found";
    private final String alreadyExistMsg = "BusTrip already exist";
    BusTripDao busTripDao = new busTripDaoImpl();
    BusDao busDao = new busDaoImpl();
    UserDao userDao = new userDaoImpl();
    @Override
    public BusTripDTO addBusTrip(BusTripDTO busTrip)
        throws NullValueException, AlreadyExistException {
        if (busTrip.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        BusTripDB busTripDB = BusTripMapper.INSTANCE.busTripDtoToBusTripDb(busTrip);
        BusDB bus = busDao.readBusById(busTrip.getRefBusId());
        UserDB user = userDao.readUserById(busTrip.getRefUserId());
        busTripDB.setBus(bus);
        busTripDB.setUser(user);
        busTripDao.saveBusTrip(busTripDB);
        //add the trip to the user bustrip list
        if (user.getBusTrips() !=null & user !=null) {
            //get user list of trips
            List<BusTripDB> busTrips = new ArrayList<>(user.getBusTrips());
            for ( BusTripDB i : busTrips) {
                if (i.getId() == busTripDB.getId()){
                    //if the trip already found don't added to the list again
                    throw new AlreadyExistException(alreadyExistMsg);
                }
            }
            //if trip not found add it
            busTrips.add(busTripDB);
            user.setBusTrips(busTrips);
        }
        else {
            List<BusTripDB> busTrips = Arrays.asList(busTripDB);
            user.setBusTrips(busTrips);
        }
        userDao.saveUser(user);
        return BusTripMapper.INSTANCE.busTripDbToBusTripDto(busTripDao.readBusTripById(busTrip.getId()));
    }

    @Override
    public BusTripDTO updateBusTrip(BusTripDTO busTrip) throws NullValueException, NotFoundException {
        if (busTrip.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        BusTripDB busTripDB = BusTripMapper.INSTANCE.busTripDtoToBusTripDb(busTrip);
        if (busTripDao.readBusTripById(busTrip.getId()) != null) {
            busTripDao.updateBusTrip(busTripDB);
            return BusTripMapper.INSTANCE.busTripDbToBusTripDto(busTripDao.readBusTripById(busTrip.getId()));
        }
        else {
            throw new NotFoundException(notFoundMsg);
        }
    }
}
