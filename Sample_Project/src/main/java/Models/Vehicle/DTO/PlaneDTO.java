package Models.Vehicle.DTO;


public class PlaneDTO extends VehicleDTO {
    private String airport;
    private String airlines;


    //getters & setters
    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }


}
