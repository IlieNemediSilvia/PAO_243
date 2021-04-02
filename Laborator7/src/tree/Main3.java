package tree;

import java.util.Random;
import java.util.TreeSet;

public class Main3 {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        Random random = new Random();
        for(int i=0; i< 100; i++){
            numbers.add(random.nextInt(100));
        }
        for(int number: numbers){
            System.out.println(number);
        }
        System.out.println("Total: " + numbers.size());
    }
}
