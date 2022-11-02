package com.exalt.transportationbookingsystem.models.person.db;

import com.aerospike.mapper.annotations.AerospikeRecord;

/**
 * The type Driver db.
 */
@AerospikeRecord(namespace="test", set="driver")
public class DriverDB extends PersonDB {
    private String license;
    private int yearsOfExp;
    private Float rate;
    private int noOfRatings;

  /**
   * Instantiates a new Driver db.
   */
  public DriverDB() {
    super();
  }

  /**
   * Gets license.
   *
   * @return the license
   */
  public String getLicense() {
        return license;
    }

  /**
   * Sets license.
   *
   * @param license the license
   */
  public void setLicense(String license) {
        this.license = license;
    }

  /**
   * Gets rate.
   *
   * @return the rate
   */
  public Float getRate() {
        return rate;
    }

  /**
   * Sets rate.
   *
   * @param rate the rate
   */
  public void setRate(Float rate) {
        this.rate = rate;
    }

  /**
   * Gets years of experience.
   *
   * @return the years of exp
   */
  public int getYearsOfExp() {
        return yearsOfExp;
    }

  /**
   * Sets years of experience.
   *
   * @param yearsOfExp the years of exp
   */
  public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

  /**
   * Gets no of ratings.
   *
   * @return the no of ratings
   */
  public int getNoOfRatings() {
        return noOfRatings;
    }

  /**
   * Sets no of ratings.
   *
   * @param noOfRatings the no of ratings
   */
  public void setNoOfRatings(int noOfRatings) {
        this.noOfRatings = noOfRatings;
    }

  /**
   * Instantiates a new Driver db.
   *
   * @param id          the id
   * @param age         the age
   * @param gender      the gender
   * @param phone       the phone
   * @param email       the email
   * @param license     the license
   * @param yearsOfExp  the years of experience
   * @param rate        the rate
   * @param noOfRatings the no of ratings
   */
  public DriverDB(int id, int age, String gender, String phone, String email, String license,
        int yearsOfExp, Float rate, int noOfRatings) {
        super(id, age, gender, phone, email);
        this.license = license;
        this.yearsOfExp = yearsOfExp;
        this.rate = rate;
        this.noOfRatings = noOfRatings;
    }
}
