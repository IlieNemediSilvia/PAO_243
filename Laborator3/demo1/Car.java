package unibuc.demo1;

public class Car extends Vehicle{
    String fuel;

    public Car(){
        super(null, 0);
        System.out.println("Car constructor no params");
    }
    public Car(String model, int noWheels, String fuel){
        super(model, noWheels);
        this.fuel = fuel;
        System.out.println("Car constructor with params");
    }
    public Car(String model, String fuel){
        super(model, 4);
        this.fuel = fuel;
        System.out.println("Car constructor with params");
    }

    @Override
    protected void stop() {
        System.out.println("Car stopped");
    }
    @Override
    protected void start() {
        System.out.println("Car started");
    }
}
