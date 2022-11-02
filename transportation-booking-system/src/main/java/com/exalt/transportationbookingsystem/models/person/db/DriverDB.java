package com.exalt.transportationbookingsystem.models.person.db;

import com.aerospike.mapper.annotations.AerospikeRecord;

@AerospikeRecord(namespace="test", set="driver")
public class DriverDB extends PersonDB {
    private String license;
    private int yearsOfExp; //experience
    private Float rate;
    private int noOfRatings;

  public DriverDB() {
    super();
  }

  //getters& setters

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public int getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    public int getNoOfRatings() {
        return noOfRatings;
    }

    public void setNoOfRatings(int noOfRatings) {
        this.noOfRatings = noOfRatings;
    }

    //constructor

    public DriverDB(int id, int age, String gender, String phone, String email, String license,
        int yearsOfExp, Float rate, int noOfRatings) {
        super(id, age, gender, phone, email);
        this.license = license;
        this.yearsOfExp = yearsOfExp;
        this.rate = rate;
        this.noOfRatings = noOfRatings;
    }
}
