package Models.Vehicle.DTO;

import Models.Person.DTO.DriverDTO;

public class VehicleDTO {

    protected int id;
    protected String license;
    protected String manifac_country;
    protected String model;
    protected String colour;
    protected int no_of_seats;
    protected Integer refDriverId;

    protected DriverDTO refDriver;

    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getManifac_country() {
        return manifac_country;
    }

    public void setManifac_country(String manifacturing_country) {
        this.manifac_country = manifacturing_country;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getNo_of_seats() {
        return no_of_seats;
    }

    public void setNo_of_seats(int no_of_seats) {
        this.no_of_seats = no_of_seats;
    }

    public Integer getRefDriverId() {
        return refDriverId;
    }

    public void setRefDriverId(Integer refDriverId) {
        this.refDriverId = refDriverId;
    }

    public DriverDTO getRefDriver() {
        return refDriver;
    }

    public void setRefDriver(DriverDTO refDriver) {
        this.refDriver = refDriver;
    }
}
