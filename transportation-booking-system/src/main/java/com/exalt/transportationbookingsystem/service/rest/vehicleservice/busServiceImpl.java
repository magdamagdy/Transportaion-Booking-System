package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.dataaccess.persondao.DriverDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.driverDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.BusDao;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.busDaoImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.BusMapper;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;


public class busServiceImpl implements BusService {

    private final String nullValueMsg = "Null object or Null id";
    private final String notFoundMsg = "Bus not found";
    BusDao busDao = new busDaoImpl();
    DriverDao driverDao = new driverDaoImpl();
    @Override
    public BusDTO addBus(BusDTO bus) throws NullValueException {
        if (bus.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        BusDB busDB = BusMapper.INSTANCE.busDtoToBusDb(bus);
        DriverDB driver = driverDao.readDriverById(bus.getRefDriverId());
        busDB.setDriver(driver);
        busDao.saveBus(busDB);
        BusDTO savedBus= BusMapper.INSTANCE.busDbToBusDto(busDao.readBusById(bus.getId()));
        return savedBus;
    }

    @Override
    public BusDTO updateBus(BusDTO bus) throws NullValueException, NotFoundException {
        if (bus.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        BusDB busDB = BusMapper.INSTANCE.busDtoToBusDb(bus);
        if (busDao.readBusById(bus.getId()) != null) {
            busDao.updateBus(busDB);
            BusDTO updatedBus= BusMapper.INSTANCE.busDbToBusDto(busDao.readBusById(bus.getId()));
            return updatedBus;
        }
        else {
            throw new NotFoundException(notFoundMsg);
        }
    }

}
