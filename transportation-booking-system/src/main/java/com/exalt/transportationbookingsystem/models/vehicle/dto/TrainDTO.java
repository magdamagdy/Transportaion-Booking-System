package com.exalt.transportationbookingsystem.models.vehicle.dto;


public class TrainDTO extends VehicleDTO {
    private String railwayStation;

    //getters & setters
    public String getRailwayStation() {
        return railwayStation;
    }

    public void setRailwayStation(String railwayStation) {
        this.railwayStation = railwayStation;
    }


}
