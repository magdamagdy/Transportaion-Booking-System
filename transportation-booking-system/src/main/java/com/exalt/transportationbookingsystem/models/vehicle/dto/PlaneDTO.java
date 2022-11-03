package com.exalt.transportationbookingsystem.models.vehicle.dto;


import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;

/**
 * The type Plane dto.
 */
public class PlaneDTO extends VehicleDTO {
    private String airport;
    private String airlines;

    /**
     * Gets airport.
     *
     * @return the airport
     */
    public String getAirport() {
        return airport;
    }

    /**
     * Sets airport.
     *
     * @param airport the airport
     */
    public void setAirport(String airport) {
        this.airport = airport;
    }

    /**
     * Gets airlines.
     *
     * @return the airlines
     */
    public String getAirlines() {
        return airlines;
    }

    /**
     * Sets airlines.
     *
     * @param airlines the airlines
     */
    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    /**
     * Instantiates a new Plane dto.
     */
    public PlaneDTO() {
    }

    /**
     * Instantiates a new Plane dto.
     *
     * @param id             the id
     * @param license        the license
     * @param manifacCountry the manifac country
     * @param model          the model
     * @param colour         the colour
     * @param noOfSeats      the no of seats
     * @param refDriverId    the ref driver id
     * @param airport        the airport
     * @param airlines       the airlines
     */
    public PlaneDTO(int id, String license, String manifacCountry, String model, String colour,
        int noOfSeats, Integer refDriverId, String airport,
        String airlines) {
        super(id, license, manifacCountry, model, colour, noOfSeats, refDriverId);
        this.airport = airport;
        this.airlines = airlines;
    }
}
