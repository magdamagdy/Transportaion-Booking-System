package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.dataaccess.personrepository.DriverRepository;
import com.exalt.transportationbookingsystem.dataaccess.personrepository.DriverRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.TrainRepository;
import com.exalt.transportationbookingsystem.dataaccess.vehiclerepository.TrainRepositoryImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.TrainMapper;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

/**
 * The type Train service.
 */
public class TrainServiceImpl implements TrainService {

    private final String nullValueMsg = "Null object or Null id";
    private final String notFoundMsg = "Train not found";
    /**
     * The Train dao.
     */
    TrainRepository trainDao = new TrainRepositoryImpl();
    /**
     * The Driver dao.
     */
    DriverRepository driverDao = new DriverRepositoryImpl();
    @Override
    public TrainDTO addTrain(TrainDTO train) throws NullValueException {
        if (train.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        TrainDB trainDB = TrainMapper.INSTANCE.trainDtoToTrainDb(train);
        DriverDB driver = driverDao.readDriverById(train.getRefDriverId());
        trainDB.setDriver(driver);
        trainDao.saveTrain(trainDB);
        TrainDTO savedTrain = TrainMapper.INSTANCE.trainDbToTrainDto(trainDao.readTrainById(train.getId()));
        return savedTrain;
    }

    @Override
    public TrainDTO updateTrain(TrainDTO train) throws NullValueException, NotFoundException {
        if (train.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        TrainDB trainDB = TrainMapper.INSTANCE.trainDtoToTrainDb(train);
        if (trainDao.readTrainById(train.getId()) != null){
            trainDao.updateTrain(trainDB);
            TrainDTO updatedTrain = TrainMapper.INSTANCE.trainDbToTrainDto(trainDao.readTrainById(train.getId()));
            return updatedTrain;
        }
        else {
            throw new NotFoundException(notFoundMsg);
        }
    }
}
