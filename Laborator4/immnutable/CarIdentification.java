package unibuc.immnutable;

public class CarIdentification {
    private String licencePlate;

    public CarIdentification(String licencePlate){
        this.licencePlate = licencePlate;
    }
    public CarIdentification (CarIdentification carId){
        this.licencePlate = carId.licencePlate;
    }
    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
    public String getLicencePlate() {
        return licencePlate;
    }
}
