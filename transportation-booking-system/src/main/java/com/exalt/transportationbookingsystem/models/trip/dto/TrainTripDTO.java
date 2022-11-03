package com.exalt.transportationbookingsystem.models.trip.dto;


import com.exalt.transportationbookingsystem.models.person.dto.UserDTO;
import com.exalt.transportationbookingsystem.models.vehicle.dto.TrainDTO;

/**
 * The type Train trip dto.
 */
public class TrainTripDTO extends TripDTO {

    private String trainClass;

    private Integer refTrainId;

    private TrainDTO refTrain;


    /**
     * Gets train class.
     *
     * @return the train class
     */
    public String getTrainClass() {
        return trainClass;
    }

    /**
     * Sets train class.
     *
     * @param trainClass the train class
     */
    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    /**
     * Gets ref train id.
     *
     * @return the ref train id
     */
    public Integer getRefTrainId() {
        return refTrainId;
    }

    /**
     * Sets ref train id.
     *
     * @param refTrainId the ref train id
     */
    public void setRefTrainId(Integer refTrainId) {
        this.refTrainId = refTrainId;
    }

    /**
     * Gets ref train.
     *
     * @return the ref train
     */
    public TrainDTO getRefTrain() {
        return refTrain;
    }

    /**
     * Sets ref train.
     *
     * @param refTrain the ref train
     */
    public void setRefTrain(TrainDTO refTrain) {
        this.refTrain = refTrain;
    }

    /**
     * Instantiates a new Train trip dto.
     */
    public TrainTripDTO() {
    }

    /**
     * Instantiates a new Train trip dto.
     *
     * @param id            the id
     * @param date          the date
     * @param seatNo        the seat no
     * @param departureTime the departure time
     * @param arrivalTime   the arrival time
     * @param startLocation the start location
     * @param destination   the destination
     * @param refUserId     the ref user id
     * @param trainClass    the train class
     * @param refTrainId    the ref train id
     */
    public TrainTripDTO(int id, String date, int seatNo, String departureTime, String arrivalTime,
        String startLocation, String destination, Integer refUserId,
         String trainClass,
        Integer refTrainId) {
        super(id, date, seatNo, departureTime, arrivalTime, startLocation, destination, refUserId);
        this.trainClass = trainClass;
        this.refTrainId = refTrainId;
    }

}
