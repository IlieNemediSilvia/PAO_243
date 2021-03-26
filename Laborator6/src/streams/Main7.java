package streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class Main7 {
    public static void main(String[] args) {
        byte[] numbers = new byte[10];
        Random random = new Random();
        for(int i =0; i< numbers.length; i++){
            numbers[i] = (byte)random.nextInt(100);
            System.out.print(numbers[i] + " ");
        }

        try(FileOutputStream stream = new FileOutputStream("data/example7.txt")){
            stream.write(numbers.length);
            stream.write(numbers);
            System.out.println(".. writing done");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(FileInputStream stream = new FileInputStream("data/example7.txt")){
            byte[] numbersFromFile = new byte[stream.read()];
            stream.read(numbersFromFile);
            for(int i=0; i< numbersFromFile.length; i++){
                System.out.print(numbersFromFile[i] + " ");
            }
            System.out.println(".. reading done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
