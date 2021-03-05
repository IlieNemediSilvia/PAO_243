package unibuc.demo3;

public class Program {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.sum(4, 5);
        calculator.sum(56, 7, 45);
        calculator.sum(7, 4.5f);
        calculator.sum(1.2f, 68);
    }
}
