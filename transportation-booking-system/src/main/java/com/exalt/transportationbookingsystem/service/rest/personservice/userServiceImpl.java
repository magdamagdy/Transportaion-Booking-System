package com.exalt.transportationbookingsystem.service.rest.personservice;


import com.exalt.transportationbookingsystem.dataaccess.persondao.UserDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.userDaoImpl;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import com.exalt.transportationbookingsystem.models.person.mapperinterfaces.UserMapper;


/**
 * The type User service.
 */
public class userServiceImpl implements UserService {

    private final String nullValueMsg = "Null object or Null id";
    private final String notFoundMsg = "User not found";
    /**
     * The User dao.
     */
    UserDao userDao = new userDaoImpl();

    @Override
    public UserDTO addUser(UserDTO user) throws NullValueException {
        if (user.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        UserDB userDB = UserMapper.INSTANCE.userDtoToUserDb(user);
        userDao.saveUser(userDB);
        UserDTO savedUser = UserMapper.INSTANCE.userDbToUserDto(userDao.readUserById(user.getId()));
        return savedUser;
    }

    @Override
    public UserDTO updateUser(UserDTO user) throws NullValueException, NotFoundException {
        if (user.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        UserDB userDB = UserMapper.INSTANCE.userDtoToUserDb(user);
        if (userDao.readUserById(user.getId())!= null) {
            userDao.updateUser(userDB);
            UserDTO updatedUser = UserMapper.INSTANCE.userDbToUserDto(userDao.readUserById(user.getId()));
            return updatedUser;
        }
        else {
            throw new NotFoundException(notFoundMsg);
        }
    }
}
