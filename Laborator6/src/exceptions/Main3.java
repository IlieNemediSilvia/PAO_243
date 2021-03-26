package exceptions;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("1. Division by zero");
        System.out.println("2. Out of bounds");
        System.out.println("3. Number format");
        System.out.println("4. File not found");
        System.out.println("5. Infinity recursion");
        System.out.println("0. Exit");

        try(Scanner scanner = new Scanner(System.in)){
            loop:
            while(true){
                try{
                    System.out.println("Select: ");
                    switch (scanner.nextInt()) {
                        case 0:
                            break loop;
                        case 1:
                            System.out.println(1 / 0);
                            break;
                        case 2:
                            System.out.println((new int[1])[4]);
                            break;
                        case 3:
                            Integer.parseInt("test");
                            break;
                        case 4:
                            new FileInputStream("test.txt").read();
                            break;
                        case 5:
                            f(1);
                            break;
                        default:
                            throw new Throwable("Invalid selection");
                    }
                }
                catch (RuntimeException exception){
                    System.out.println("Runtime exception: " + exception);
                }
                catch (Exception exception){
                    System.out.println("Exception: " + exception);
                }
                catch (Error error){
                    System.out.println("Error: " + error);
                }
                catch (Throwable throwable){
                    System.out.println("Throwable: " + throwable);
                }
            }
        }
    }
    private static int f(int i){
        return f(++i);
    }
}
