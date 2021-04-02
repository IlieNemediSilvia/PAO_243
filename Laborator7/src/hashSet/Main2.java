package hashSet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Main2 {
    public static void main(String[] args) {
        List<City> vector = new Vector<>();
        try {
            for(String line: Files.readAllLines(Paths.get("data/cities.csv"))){
                vector.add(new City(line.split(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buildSet(vector, "name");
        System.out.println();
        buildSet(vector, "district");
    }
    public static void buildSet(List<City> cities, String field){
        City.field = field;
        Set<City> hashSet = new HashSet<>();
        for(City city: cities){
            hashSet.add(city);
        }
        for(City city : hashSet){
            System.out.println(city);
        }
        System.out.println("Total: " + hashSet.size());
    }
}
