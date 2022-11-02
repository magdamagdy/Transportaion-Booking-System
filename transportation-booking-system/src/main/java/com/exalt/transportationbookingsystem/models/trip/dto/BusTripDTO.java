package com.exalt.transportationbookingsystem.models.trip.dto;


import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;

public class BusTripDTO extends TripDTO {


    private Integer refBusId;

    // refBus is used in get request to set the bus entity
    private BusDTO refBus;

    //setter & getter

    public Integer getRefBusId() {
        return refBusId;
    }

    public void setRefBusId(Integer refBusId) {
        this.refBusId = refBusId;
    }

    public BusDTO getRefBus() {
        return refBus;
    }

    public void setRefBus(BusDTO refBus) {
        this.refBus = refBus;
    }
}
