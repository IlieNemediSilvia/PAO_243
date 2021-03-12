package unibuc.immnutable;

public class Program {
    public static void main(String[] args) {
        CarIdentification carIdentification = new CarIdentification("B122ABC");
        ImmnutableCar car = new ImmnutableCar(2016, carIdentification);
        System.out.println(carIdentification == car.getCarIdentification());
        carIdentification.setLicencePlate("B189DEF");
        System.out.println(car.getCarIdentification().getLicencePlate());
        CarIdentification carId2 = car.getCarIdentification();
        carId2.setLicencePlate("B55ZGW");
        System.out.println(car.getCarIdentification().getLicencePlate());
        car.setCarIdentification(carId2);
    }
}
