package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.dataaccess.persondao.DriverDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.driverDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.TrainDao;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.trainDaoImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.TrainMapper;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

public class trainServiceImpl implements TrainService {

    private final String nullValueMsg = "Null object or Null id";
    private final String notFoundMsg = "Train not found";
    TrainDao trainDao = new trainDaoImpl();
    DriverDao driverDao = new driverDaoImpl();
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
