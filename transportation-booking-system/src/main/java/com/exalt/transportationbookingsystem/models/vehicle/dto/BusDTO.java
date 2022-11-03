package com.exalt.transportationbookingsystem.models.vehicle.dto;

import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;

/**
 * The type Bus dto.
 */
public class BusDTO extends VehicleDTO{

  /**
   * Instantiates a new Bus dto.
   */
  public BusDTO() {
  }

  /**
   * Instantiates a new Bus dto.
   *
   * @param id             the id
   * @param license        the license
   * @param manifacCountry the manifac country
   * @param model          the model
   * @param colour         the colour
   * @param noOfSeats      the no of seats
   * @param refDriverId    the ref driver id
   */
  public BusDTO(int id, String license, String manifacCountry, String model, String colour,
      int noOfSeats, Integer refDriverId) {
    super(id, license, manifacCountry, model, colour, noOfSeats, refDriverId);
  }
}
