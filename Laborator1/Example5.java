package unibuc;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first:");
        int first = scanner.nextInt();
        System.out.println("Enter second:");
        int second = scanner.nextInt();
        int sum = first + second;
        System.out.println("Sum is " + sum);
        if(first == second) {
            System.out.println("Numbers are equal");
        }
        else if(first < second){
            System.out.println(first + " is less than " + second);
        }
        else {
            System.out.println(first + " is greater than " + second);
        }
    }
}
