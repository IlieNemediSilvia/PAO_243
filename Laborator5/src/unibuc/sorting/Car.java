package unibuc.sorting;

public class Car implements Comparable{
    private int age;
    private String brand;
    private String type;

    public Car(int age, String brand, String type) {
        this.age = age;
        this.brand = brand;
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(Object o) {
        Car car =(Car)o;
        return this.brand.compareTo(car.getBrand());
    }

    @Override
    public String toString() {
        return "Car{" +
                "age=" + age +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
