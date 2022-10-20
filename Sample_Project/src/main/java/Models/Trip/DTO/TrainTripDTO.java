package Models.Trip.DTO;

import Models.Vehicle.DTO.TrainDTO;

public class TrainTripDTO extends TripDTO {

    private String trainClass;

    private Integer refTrainId;

    // refTrain is used in get request to set the train entity
    private TrainDTO refTrain;


    //setters & getters
    public String getTrainClass() {
        return trainClass;
    }

    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    public Integer getRefTrainId() {
        return refTrainId;
    }

    public void setRefTrainId(Integer refTrainId) {
        this.refTrainId = refTrainId;
    }

    public TrainDTO getRefTrain() {
        return refTrain;
    }

    public void setRefTrain(TrainDTO refTrain) {
        this.refTrain = refTrain;
    }
}
