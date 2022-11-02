package com.exalt.transportationbookingsystem.models.person.dto;

import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;

import java.util.List;

public class UserTripListsDTO {
    private List<BusTripDTO> busTrip;


    private List<TrainTripDTO> trainTrip;

    private List<FlightDTO> flight;


    //getters & setters

    public List<BusTripDTO> getBusTrip() {
        return busTrip;
    }

    public void setBusTrip(List<BusTripDTO> busTrip) {
        this.busTrip = busTrip;
    }

    public List<TrainTripDTO> getTrainTrip() {
        return trainTrip;
    }

    public void setTrainTrip(List<TrainTripDTO> trainTrip) {
        this.trainTrip = trainTrip;
    }

    public List<FlightDTO> getFlight() {
        return flight;
    }

    public void setFlight(List<FlightDTO> flight) {
        this.flight = flight;
    }
}
