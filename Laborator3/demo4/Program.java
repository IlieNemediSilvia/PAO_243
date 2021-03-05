package unibuc.demo4;

public class Program {
    public static void main(String[] args) {
        City city1 = new City("Timisoara", "Timis", 300000);
        City city2 = new City("Timisoara", "Timis", 300000);
        City city3 = city1;

        System.out.println(city1 == city2);
        System.out.println(city1 == city3);
        System.out.println(city1.equals(city2));
        System.out.println(city1.equals(city3));
    }
}
