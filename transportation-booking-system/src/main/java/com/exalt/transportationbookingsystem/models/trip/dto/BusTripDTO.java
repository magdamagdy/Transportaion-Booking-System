package com.exalt.transportationbookingsystem.models.trip.dto;

import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;

/**
 * The type Bus trip dto.
 */
public class BusTripDTO extends TripDTO {

    private Integer refBusId;
    private BusDTO refBus;

    /**
     * Gets ref bus id.
     *
     * @return the ref bus id
     */
    public Integer getRefBusId() {
        return refBusId;
    }

    /**
     * Sets ref bus id.
     *
     * @param refBusId the ref bus id
     */
    public void setRefBusId(Integer refBusId) {
        this.refBusId = refBusId;
    }

    /**
     * Gets ref bus.
     *
     * @return the ref bus
     */
    public BusDTO getRefBus() {
        return refBus;
    }

    /**
     * Sets ref bus.
     *
     * @param refBus the ref bus
     */
    public void setRefBus(BusDTO refBus) {
        this.refBus = refBus;
    }

    /**
     * Instantiates a new Bus trip dto.
     */
    public BusTripDTO() {
    }

    /**
     * Instantiates a new Bus trip dto.
     *
     * @param id            the id
     * @param date          the date
     * @param seatNo        the seat no
     * @param departureTime the departure time
     * @param arrivalTime   the arrival time
     * @param startLocation the start location
     * @param destination   the destination
     * @param refUserId     the ref user id
     * @param refBusId      the ref bus id
     */
    public BusTripDTO(int id, String date, int seatNo, String departureTime, String arrivalTime,
        String startLocation, String destination, Integer refUserId,
         Integer refBusId) {
        super(id, date, seatNo, departureTime, arrivalTime, startLocation, destination, refUserId);
        this.refBusId = refBusId;
    }
}
