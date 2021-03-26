package exceptions;

import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        String[] planets = {"Neptune", "Uranus", "Saturn", "Jupiter", "Mars", "Earth", "Venus", "Mercury", "Sun"};
        for(String planet : planets){
            System.out.println("Visiting planet " + planet);
            try {
                visit(planet);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            finally {
                System.out.println("Leaving planet " + planet);
            }
        }
    }
    private static void visit(String planet) throws Exception {
        if("Sun".equals(planet)){
            System.exit(0);
        }
        if(new Random().nextBoolean()){
            throw new Exception("Something went wrong!");
        }
        System.out.println("All went well.");
    }
}
