package com.exalt.transportationbookingsystem.models.trip.dto;


import com.exalt.transportationbookingsystem.models.vehicle.dto.PlaneDTO;

/**
 * The type Flight dto.
 */
public class FlightDTO extends TripDTO {

    private String flightClass;

    private Integer refPlaneId;

    private PlaneDTO refPlane;

    /**
     * Gets flight class.
     *
     * @return the flight class
     */
    public String getFlightClass() {
        return flightClass;
    }

    /**
     * Sets flight class.
     *
     * @param flightClass the flight class
     */
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    /**
     * Gets ref plane id.
     *
     * @return the ref plane id
     */
    public Integer getRefPlaneId() {
        return refPlaneId;
    }

    /**
     * Sets ref plane id.
     *
     * @param refPlaneId the ref plane id
     */
    public void setRefPlaneId(Integer refPlaneId) {
        this.refPlaneId = refPlaneId;
    }

    /**
     * Gets ref plane.
     *
     * @return the ref plane
     */
    public PlaneDTO getRefPlane() {
        return refPlane;
    }

    /**
     * Sets ref plane.
     *
     * @param refPlane the ref plane
     */
    public void setRefPlane(PlaneDTO refPlane) {
        this.refPlane = refPlane;
    }
}
