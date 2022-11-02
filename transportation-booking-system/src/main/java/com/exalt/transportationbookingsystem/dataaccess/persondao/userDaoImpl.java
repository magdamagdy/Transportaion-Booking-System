package com.exalt.transportationbookingsystem.dataaccess.persondao;

import com.exalt.transportationbookingsystem.dbconfiguration.database;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import java.util.List;

public class userDaoImpl implements UserDao {

  private final String age = "age";
  private final String gender = "gender";
  private final String  phone = "phone";
  private final String email = "email";

  /**
   * The Aerospike Instance.
   */
  database aerospike = database.getInstance();

  @Override
  public void saveUser(UserDB user){
      aerospike.mapper.save(user);
  }

  @Override
  public void updateUser(UserDB user){
      aerospike.mapper.update(age,gender ,phone ,email);
  }

  @Override
  public UserDB readUserById(int id){
    return aerospike.mapper.read(UserDB.class, id);
  }

  @Override
  public List<UserDB> readAllUsers(){
    return aerospike.mapper.scan(UserDB.class);
  }

  @Override
  public void deleteUserById(int id){
      aerospike.mapper.delete(UserDB.class, id);
  }

}
