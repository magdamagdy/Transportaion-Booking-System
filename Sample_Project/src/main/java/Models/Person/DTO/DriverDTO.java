package Models.Person.DTO;

public class DriverDTO extends PersonDTO {
    private String license;
    private int years_of_exp; //experience
    private Float rate;
    private int no_of_ratings;


    //getters& setters

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getYears_of_experience() {
        return years_of_exp;
    }

    public void setYears_of_experience(int years_of_experience) {
        this.years_of_exp = years_of_experience;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public int getNo_of_ratings() {
        return no_of_ratings;
    }

    public void setNo_of_ratings(int no_of_ratings) {
        this.no_of_ratings = no_of_ratings;
    }


}
