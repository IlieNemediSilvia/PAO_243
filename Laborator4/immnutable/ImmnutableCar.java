package unibuc.immnutable;

public final class ImmnutableCar {
    private final Integer year;
    private final CarIdentification carId;
    public ImmnutableCar(Integer year, CarIdentification carId) {
        this.carId = new CarIdentification(carId);
        this.year = year;
    }
    public CarIdentification getCarIdentification(){
        return new CarIdentification(carId);
    }
    public void setCarIdentification(CarIdentification carIdentification){
        throw new UnsupportedOperationException("Operation is not allowed.");
    }
}
