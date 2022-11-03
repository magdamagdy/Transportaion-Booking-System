package com.exalt.transportationbookingsystem.models.person.dto;


/**
 * The type User dto.
 */
public class UserDTO extends PersonDTO {

  /**
   * Instantiates a new User dto.
   */
  public UserDTO() {
  }

  /**
   * Instantiates a new User dto.
   *
   * @param id     the id
   * @param age    the age
   * @param gender the gender
   * @param phone  the phone
   * @param email  the email
   */
  public UserDTO(int id, int age, String gender, String phone, String email) {
    super(id, age, gender, phone, email);
  }
}
