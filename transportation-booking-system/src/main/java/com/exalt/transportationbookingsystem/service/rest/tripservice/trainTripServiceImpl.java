package com.exalt.transportationbookingsystem.service.rest.tripservice;

import com.exalt.transportationbookingsystem.dataaccess.persondao.UserDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.userDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.TrainTripDao;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.trainTripDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.TrainDao;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.trainDaoImpl;
import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.db.TrainTripDB;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;
import com.exalt.transportationbookingsystem.models.trip.mapperinterfaces.TrainTripMapper;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class trainTripServiceImpl implements TrainTripService {

    private final String nullValueMsg = "Null object or Null id";
    private final String notFoundMsg = "TrainTrip not found";
    private final String alreadyExistMsg = "TrainTrip already exist";
    TrainTripDao trainTripDao = new trainTripDaoImpl();
    TrainDao trainDao = new trainDaoImpl();
    UserDao userDao = new userDaoImpl();
    @Override
    public TrainTripDTO addTrainTrip(TrainTripDTO trainTrip)
        throws NullValueException, AlreadyExistException {
        if (trainTrip.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        TrainTripDB trainTripDB = TrainTripMapper.INSTANCE.trainTripDtoToTrainTripDb(trainTrip);
        TrainDB train =trainDao.readTrainById(trainTrip.getRefTrainId());
        UserDB user = userDao.readUserById(trainTrip.getRefUserId());
        trainTripDB.setTrain(train);
        trainTripDB.setUser(user);
        trainTripDao.saveTrainTrip(trainTripDB);
        //add the trip to the user traintrip list
        if (user.getTrainTrips() !=null & user !=null) {
            //get user list of trips
            List<TrainTripDB> trainTrips = new ArrayList<>(user.getTrainTrips());

            for ( TrainTripDB i : trainTrips) {
                if (i.getId() == trainTripDB.getId()){
                    //if the trip already found don't added to the list again
                    throw new AlreadyExistException(alreadyExistMsg);
                }
            }
            //if trip not found add it
            trainTrips.add(trainTripDB);
            user.setTrainTrips(trainTrips);
        }
        else {
            List<TrainTripDB> trainTrips = Arrays.asList(trainTripDB);
            user.setTrainTrips(trainTrips);
        }
        userDao.saveUser(user);
        return TrainTripMapper.INSTANCE.trainTripDbToTrainTripDto(trainTripDao.readTrainTripById(trainTrip.getId()));

    }

    @Override
    public TrainTripDTO updateTrainTrip(TrainTripDTO trainTrip)
        throws NullValueException, NotFoundException {
        if (trainTrip.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        TrainTripDB trainTripDB = TrainTripMapper.INSTANCE.trainTripDtoToTrainTripDb(trainTrip);
        if (trainTripDao.readTrainTripById(trainTrip.getId()) != null){
            trainTripDao.updateTrainTrip(trainTripDB);
            return TrainTripMapper.INSTANCE.trainTripDbToTrainTripDto(trainTripDao.readTrainTripById(trainTrip.getId()));
        }
        else {
            throw new NotFoundException(notFoundMsg);
        }
    }
}
