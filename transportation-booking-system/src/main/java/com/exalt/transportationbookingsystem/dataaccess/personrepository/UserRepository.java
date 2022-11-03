package com.exalt.transportationbookingsystem.dataaccess.personrepository;

import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import java.util.List;

/**
 * The interface User dao.
 */
public interface UserRepository {

  /**
   * Save user.
   *
   * @param user the user
   */
  void saveUser(UserDB user);

  /**
   * Update user.
   *
   * @param user the user
   */
  void updateUser(UserDB user);

  /**
   * Read user by id user db.
   *
   * @param id the id
   * @return the user db
   */
  UserDB readUserById(int id);

  /**
   * Read all users list.
   *
   * @return the list of all users
   */
  List<UserDB> readAllUsers();

  /**
   * Delete user by id.
   *
   * @param id the id
   */
  void deleteUserById(int id);
}
