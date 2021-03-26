package streams;

import java.io.FileReader;
import java.nio.charset.Charset;

public class Main6 {
    public static void main(String[] args) {
        for(String encoding: new String[]{"ISO-8859-1", "UTF-8"}){
            try(FileReader reader = new FileReader("data/example6.txt", Charset.forName(encoding))){
                int c;
                while((c = reader.read()) != -1){
                    System.out.print((char)c);
                }
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
