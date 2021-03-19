package unibuc.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        Car car1 = new Car(5, "Opel", "hatchback");
        Car car2 = new Car(2, "Skoda", "sedan");
        Car car3 = new Car(7, "Ford", "suv");
        Car car4 = new Car(6, "Mazda", "sedan");
        Car car5 = new Car(2, "Ford", "sedan");

        Car[] cars ={car1, car2, car3, car4, car5};
        Arrays.sort(cars);
        printElements(cars);
        System.out.println("=================");
        Arrays.sort(cars, Collections.reverseOrder());
        printElements(cars);
        System.out.println("=================");
        Arrays.sort(cars, new CarComparator());
        printElements(cars);
        System.out.println("=================");
        Arrays.sort(cars, Comparator.comparing(Car::getBrand)
                .thenComparing(Car::getAge).thenComparing(Car::getType));
        printElements(cars);
    }

    private static void printElements(Car[] cars){
        for(Car car: cars){
            System.out.println(car);
        }
    }
}
