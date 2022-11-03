package com.exalt.transportationbookingsystem.service.soap;

import com.exalt.transportationbookingsystem.dataaccess.personrepository.DriverRepository;
import com.exalt.transportationbookingsystem.dataaccess.personrepository.UserRepository;
import com.exalt.transportationbookingsystem.dataaccess.personrepository.DriverRepositoryImpl;
import com.exalt.transportationbookingsystem.dataaccess.personrepository.UserRepositoryImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import com.exalt.transportationbookingsystem.models.person.mapperinterfaces.DriverMapper;
import com.exalt.transportationbookingsystem.models.person.mapperinterfaces.UserMapper;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Person soap service.
 */
public class PersonSoapServiceImpl implements PersonSoapService{

    private final String driverNotFoundMsg = "Driver not found";
    private final String userNotFoundMsg = "Uer not found";
    /**
     * The User dao.
     */
    UserRepository userDao = new UserRepositoryImpl();
    /**
     * The Driver dao.
     */
    DriverRepository driverDao = new DriverRepositoryImpl();
    @Override
    public UserDTO getUserById(int id) throws NotFoundException {
        UserDB userDB = userDao.readUserById(id);
        if (userDB == null){
            throw new NotFoundException(userNotFoundMsg);
        }
        UserDTO userDTO = UserMapper.INSTANCE.userDbToUserDto(userDB);
        return userDTO;
    }

    @Override
    public DriverDTO getDriverById(int id) throws NotFoundException {
        DriverDB driverDB = driverDao.readDriverById(id);
        if (driverDB == null){
            throw new NotFoundException(driverNotFoundMsg);
        }
        DriverDTO driverDTO = DriverMapper.INSTANCE.driverDbToDriverDto(driverDB);
        return driverDTO;
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<UserDB> AllUsers = new ArrayList<>(userDao.readAllUsers());
        List<UserDTO> AllUsersDTO = new ArrayList<>();
        for (UserDB i : AllUsers) {
            UserDTO userDTO = UserMapper.INSTANCE.userDbToUserDto(i);
            AllUsersDTO.add(userDTO);
        }
        return AllUsersDTO;
    }

    @Override
    public List<DriverDTO> getAllDrivers(){
        List<DriverDB> AllDrivers = new ArrayList<>(driverDao.readAllDrivers());
        List<DriverDTO> AllDriversDTO = new ArrayList<>();
        for (DriverDB i : AllDrivers) {
            DriverDTO driverDTO = DriverMapper.INSTANCE.driverDbToDriverDto(i);
            AllDriversDTO.add(driverDTO);
        }
        return AllDriversDTO;
    }

}
