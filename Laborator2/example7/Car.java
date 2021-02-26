package unibuc.example7;

public class Car {
    private int year;
    private String model;
    private String owner;
    private int nbOfAccidents;
    final boolean bool = true;

    public Car(){
    }

    public Car(String model, String owner, int year){
       //this.model = model;
        this(model);
        this.owner = owner;
        this.year = year;
    }

    public Car(String model){
        this.model = model;
    }
    public Car(String owner, int year){
        this.owner = owner;
        this.year = year;
    }
    void crash(){
        nbOfAccidents++;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", model='" + model + '\'' +
                ", owner='" + owner + '\'' +
                ", nbOfAccidents=" + nbOfAccidents +
                '}';
    }
}
