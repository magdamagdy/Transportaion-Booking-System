package Models.Person.DTO;

import Models.Trip.DTO.BusTripDTO;
import Models.Trip.DTO.FlightDTO;
import Models.Trip.DTO.TrainTripDTO;

import java.util.List;

public class UserTripListsDTO {
    private List<BusTripDTO> Bus_Trip;


    private List<TrainTripDTO> Train_Trip;

    private List<FlightDTO> flight;



    public List<BusTripDTO> getBus_Trip() {
        return Bus_Trip;
    }

    public void setBus_Trip(List<BusTripDTO> bus_Trip) {
        Bus_Trip = bus_Trip;
    }

    public List<TrainTripDTO> getTrain_Trip() {
        return Train_Trip;
    }

    public void setTrain_Trip(List<TrainTripDTO> train_Trip) {
        Train_Trip = train_Trip;
    }

    public List<FlightDTO> getFlight() {
        return flight;
    }

    public void setFlight(List<FlightDTO> flight) {
        this.flight = flight;
    }
}
