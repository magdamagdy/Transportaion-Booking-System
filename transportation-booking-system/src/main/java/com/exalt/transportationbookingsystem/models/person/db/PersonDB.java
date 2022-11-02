package com.exalt.transportationbookingsystem.models.person.db;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

/**
 * The type Person db.
 */
@AerospikeRecord(namespace="test")
public class PersonDB {

  /**
   * The Id.
   */
  @AerospikeKey
    protected int id;
  /**
   * The Age.
   */
  protected int age;
  /**
   * The Gender.
   */
  protected String gender;
  /**
   * The Phone.
   */
  protected String phone;
  /**
   * The Email.
   */
  protected String email;

  /**
   * Instantiates a new Person db.
   */
  public PersonDB() {

  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public int getId() {
        return id;
    }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(int id) {
        this.id = id;
    }

  /**
   * Gets age.
   *
   * @return the age
   */
  public int getAge() {
        return age;
    }

  /**
   * Sets age.
   *
   * @param age the age
   */
  public void setAge(int age) {
        this.age = age;
    }

  /**
   * Gets gender.
   *
   * @return the gender
   */
  public String getGender() {
        return gender;
    }

  /**
   * Sets gender.
   *
   * @param gender the gender
   */
  public void setGender(String gender) {
        this.gender = gender;
    }

  /**
   * Gets phone.
   *
   * @return the phone
   */
  public String getPhone() {
        return phone;
    }

  /**
   * Sets phone.
   *
   * @param phone the phone
   */
  public void setPhone(String phone) {
        this.phone = phone;
    }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
        return email;
    }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
        this.email = email;
    }


  /**
   * Instantiates a new Person db.
   *
   * @param id     the id
   * @param age    the age
   * @param gender the gender
   * @param phone  the phone
   * @param email  the email
   */
    public PersonDB(int id, int age, String gender, String phone, String email) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }
}
