package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.dataaccess.persondao.DriverDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.driverDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.PlaneDao;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.planeDaoImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;
import com.exalt.transportationbookingsystem.models.vehicle.mapperinterfaces.PlaneMapper;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;

/**
 * The type Plane service.
 */
public class planeServiceImpl implements PlaneService {

    private final String nullValueMsg = "Null object or Null id";
    private final String notFoundMsg = "Plane not found";
    /**
     * The Plane dao.
     */
    PlaneDao planeDao = new planeDaoImpl();
    /**
     * The Driver dao.
     */
    DriverDao driverDao = new driverDaoImpl();
    @Override
    public PlaneDTO addPlane(PlaneDTO plane) throws NullValueException {
        if (plane.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        PlaneDB planeDB = PlaneMapper.INSTANCE.planeDtoToPlaneDb(plane);
        DriverDB driver = driverDao.readDriverById(plane.getRefDriverId());
        planeDB.setDriver(driver);
        planeDao.savePlane(planeDB);
        PlaneDTO savedPlane= PlaneMapper.INSTANCE.planeDbToPlaneDto(planeDao.readPlaneById(plane.getId()));
        return savedPlane;
    }

    @Override
    public PlaneDTO updatePlane(PlaneDTO plane) throws NullValueException, NotFoundException {
        if (plane.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        PlaneDB planeDB = PlaneMapper.INSTANCE.planeDtoToPlaneDb(plane);
        if (planeDao.readPlaneById(plane.getId()) != null) {
            planeDao.updatePlane(planeDB);
            PlaneDTO updatedPlane= PlaneMapper.INSTANCE.planeDbToPlaneDto(planeDao.readPlaneById(plane.getId()));
            return updatedPlane;
        }
        else {
            throw new NotFoundException(notFoundMsg);
        }
    }
}
