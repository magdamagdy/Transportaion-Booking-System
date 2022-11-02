package com.exalt.transportationbookingsystem.dataaccess.persondao;

import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import java.util.List;

public interface UserDao {
  void saveUser(UserDB user);
  void updateUser(UserDB user);
  UserDB readUserById(int id);
  List<UserDB> readAllUsers();
  void deleteUserById(int id);
}
