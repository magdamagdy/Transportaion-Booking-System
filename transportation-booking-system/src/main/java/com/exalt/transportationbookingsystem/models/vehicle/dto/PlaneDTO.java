package com.exalt.transportationbookingsystem.models.vehicle.dto;


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


}
