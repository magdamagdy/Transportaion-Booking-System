package com.exalt.transportationbookingsystem.models.person.dto;

import com.exalt.transportationbookingsystem.models.trip.dto.BusTripDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import com.exalt.transportationbookingsystem.models.trip.dto.TrainTripDTO;

import java.util.List;

/**
 * The type User trip lists dto.
 */
public class UserTripListsDTO {
    private List<BusTripDTO> busTrip;


    private List<TrainTripDTO> trainTrip;

    private List<FlightDTO> flight;


    /**
     * Gets bus trip.
     *
     * @return the bus trip
     */
    public List<BusTripDTO> getBusTrip() {
        return busTrip;
    }

    /**
     * Sets bus trip.
     *
     * @param busTrip the bus trip
     */
    public void setBusTrip(List<BusTripDTO> busTrip) {
        this.busTrip = busTrip;
    }

    /**
     * Gets train trip.
     *
     * @return the train trip
     */
    public List<TrainTripDTO> getTrainTrip() {
        return trainTrip;
    }

    /**
     * Sets train trip.
     *
     * @param trainTrip the train trip
     */
    public void setTrainTrip(List<TrainTripDTO> trainTrip) {
        this.trainTrip = trainTrip;
    }

    /**
     * Gets flight.
     *
     * @return the flight
     */
    public List<FlightDTO> getFlight() {
        return flight;
    }

    /**
     * Sets flight.
     *
     * @param flight the flight
     */
    public void setFlight(List<FlightDTO> flight) {
        this.flight = flight;
    }
}
