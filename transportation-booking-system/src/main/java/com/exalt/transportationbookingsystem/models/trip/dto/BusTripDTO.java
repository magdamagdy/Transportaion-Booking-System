package com.exalt.transportationbookingsystem.models.trip.dto;

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
}
