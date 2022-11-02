package com.exalt.transportationbookingsystem.models.vehicle.dto;


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


}
