package com.exalt.transportationbookingsystem.models.trip.dto;


import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;

public class FlightDTO extends TripDTO {

    private String flightClass;


    private Integer refPlaneId;

    // refPlane is used in get request to set the plane entity
    private PlaneDTO refPlane;

    //getters & setters
    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public Integer getRefPlaneId() {
        return refPlaneId;
    }

    public void setRefPlaneId(Integer refPlaneId) {
        this.refPlaneId = refPlaneId;
    }

    public PlaneDTO getRefPlane() {
        return refPlane;
    }

    public void setRefPlane(PlaneDTO refPlane) {
        this.refPlane = refPlane;
    }
}
