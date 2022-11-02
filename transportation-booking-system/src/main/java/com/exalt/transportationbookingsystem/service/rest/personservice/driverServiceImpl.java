package com.exalt.transportationbookingsystem.service.rest.personservice;

import com.exalt.transportationbookingsystem.dataaccess.persondao.DriverDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.driverDaoImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import com.exalt.transportationbookingsystem.models.person.mapperinterfaces.DriverMapper;


public class driverServiceImpl implements DriverService {

    private final String nullValueMsg = "Null object or Null id";
    private final String notFoundMsg = "Driver not found";
    DriverDao driverDao = new driverDaoImpl();

    @Override
    public DriverDTO addDriver(DriverDTO driver) throws NullValueException {
        if (driver.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        DriverDB driverDB = DriverMapper.INSTANCE.driverDtoToDriverDb(driver);
        driverDao.saveDriver(driverDB);
        DriverDTO savedDriver = DriverMapper.INSTANCE.driverDbToDriverDto(driverDao.readDriverById(driver.getId()));
        return savedDriver;
    }

    @Override
    public DriverDTO updateDriver(DriverDTO driver) throws NullValueException, NotFoundException {
        if (driver.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        DriverDB driverDB = DriverMapper.INSTANCE.driverDtoToDriverDb(driver);
        if ((driverDao.readDriverById(driver.getId()) != null)) {
            driverDao.updateDriver(driverDB);
            DriverDTO updatedDriver = DriverMapper.INSTANCE.driverDbToDriverDto(driverDao.readDriverById(driver.getId()));
            return updatedDriver;
        }
        else {
            throw new NotFoundException(notFoundMsg);
        }
    }
}
