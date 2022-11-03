package com.exalt.transportationbookingsystem.models.vehicle.dto;


import com.exalt.transportationbookingsystem.models.person.dto.DriverDTO;

/**
 * The type Train dto.
 */
public class TrainDTO extends VehicleDTO {
    private String railwayStation;

    /**
     * Gets railway station.
     *
     * @return the railway station
     */
    public String getRailwayStation() {
        return railwayStation;
    }

    /**
     * Sets railway station.
     *
     * @param railwayStation the railway station
     */
    public void setRailwayStation(String railwayStation) {
        this.railwayStation = railwayStation;
    }

    /**
     * Instantiates a new Train dto.
     */
    public TrainDTO() {
    }

    /**
     * Instantiates a new Train dto.
     *
     * @param id             the id
     * @param license        the license
     * @param manifacCountry the manifac country
     * @param model          the model
     * @param colour         the colour
     * @param noOfSeats      the no of seats
     * @param refDriverId    the ref driver id
     * @param railwayStation the railway station
     */
    public TrainDTO(int id, String license, String manifacCountry, String model, String colour,
        int noOfSeats, Integer refDriverId,
        String railwayStation) {
        super(id, license, manifacCountry, model, colour, noOfSeats, refDriverId);
        this.railwayStation = railwayStation;
    }
}
