package com.exalt.transportationbookingsystem.models.person.db;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

@AerospikeRecord(namespace="test")
public class PersonDB {

    @AerospikeKey
    protected int id;
    protected int age;
    protected String gender;
    protected String phone;
    protected String email;

  public PersonDB() {

  }

  //getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //constructor
    public PersonDB(int id, int age, String gender, String phone, String email) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }
}
