package unibuc.example7;

public class Example7 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setModel("Opel");
        car1.setOwner("Popescu");
        car1.setYear(2018);
        System.out.println(car1);
        car1.crash();
        System.out.println(car1);

        Car car2 = new Car("Ford", "Ionescu", 2021);
        System.out.println(car2);
        car2.crash();
        car2.crash();
        System.out.println(car2);
    }
}
