package streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main5 {
    public static void main(String[] args) {
        try {
            merge("data/outputAll.txt", "data/input1.txt", "data/input2.txt", "data/input3.txt");
            merge("data/outputTwo.txt", "data/input1.txt", "data/input2.txt");
        } catch (IOException e) {
            System.out.println("Exception: " +e.getMessage());
        }
    }
    private static void merge(String output, String...inputs) throws IOException {
        try(FileWriter writer = new FileWriter(output)) {
            for(String input: inputs){
                try(FileReader reader = new FileReader(input)){
                    reader.transferTo(writer);
                }
            }
        }
    }
}
