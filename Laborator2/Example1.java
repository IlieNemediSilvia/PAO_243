package unibuc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Example1 {
    public static void main(String[] args) {
        String[] cities = {"Bucuresti", "Timisoara", "Constanta", "Pitesti"};
        System.out.println(cities.length);
        Arrays.sort(cities);
        System.out.println(Arrays.toString(cities));
        cities[1] = "Brasov";
        Arrays.sort(cities, Collections.reverseOrder());
        System.out.println(Arrays.toString(cities));
        Arrays.sort(cities, new Comparator<String>() {
            public int compare(String str1, String str2) {
               return str1.charAt(1) - str2.charAt(1); //sort dupa a doua litera
            }
        });
        System.out.println(Arrays.toString(cities));
    }
}
